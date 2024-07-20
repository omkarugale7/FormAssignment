package com.kodo.Assigment.controller;
import com.kodo.Assigment.model.FieldValues;
import com.kodo.Assigment.model.Submissions;
import com.kodo.Assigment.repository.FieldValuesRepository;
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
    @PostMapping("/form/{formId}/submit")
    public String submitForm(@PathVariable long formId, @RequestBody Submissions submission) {
        submission.setForm(formRepository.getById(formId));
        submissionsRepository.save(submission);
        for (FieldValues fieldValue : submission.getFieldValues()) {
            fieldValue.setSubmission(submission);
            fieldValuesRepository.save(fieldValue);
        }
    return Integer.toString(submission.getId());
    }
    @GetMapping("/form/{formId}/submissions")
    public List<Submissions> getAllSubmissions(@PathVariable long formId) {
        return formRepository.getById(formId).getSubmissions();
    }

    @GetMapping("/submissions/{submissionId}")
    public Submissions getSubmissionById(@PathVariable int submissionId) {
        return submissionsRepository.getById(submissionId);
    }
}
