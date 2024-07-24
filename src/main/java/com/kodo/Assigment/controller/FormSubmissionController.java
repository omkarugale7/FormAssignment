package com.kodo.Assigment.controller;
import com.kodo.Assigment.model.FieldValues;
import com.kodo.Assigment.model.Form;
import com.kodo.Assigment.model.Submissions;
import com.kodo.Assigment.repository.FieldValuesRepository;
import com.kodo.Assigment.repository.FieldsRepository;
import com.kodo.Assigment.repository.FormRepository;
import com.kodo.Assigment.repository.SubmissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormSubmissionController {
    @Autowired
    private SubmissionsRepository submissionsRepository;
    @Autowired
    private FieldValuesRepository fieldValuesRepository;
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private FieldsRepository fieldsRepository;
    @PostMapping("/form/{formId}/submit")
    public String submitForm(@PathVariable long formId, @RequestBody Submissions submission) {
        submission.setForm(formRepository.getById(formId));
        submissionsRepository.save(submission);
        for (FieldValues fieldValue : submission.getFieldValues()) {
            fieldValue.setSubmission(submission);
            fieldValue.setField(fieldsRepository.findById(fieldValue.getField_id_temp()).get());
            fieldValuesRepository.save(fieldValue);
        }
    return Integer.toString(submission.getId());
    }
    @GetMapping("/form/{formId}/submissions")
    public List<Submissions> getAllSubmissions(@PathVariable long formId) {
//        Form form = formRepository.getById(formId);
        Form form = formRepository.findById(formId).get();
        return ((Form) form).getSubmissions();
    }


    @GetMapping("/submissions/{submissionId}")
    public Submissions getSubmissionById(@PathVariable int submissionId) {
        return submissionsRepository.getById(submissionId);
    }
}
