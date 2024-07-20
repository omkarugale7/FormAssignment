package com.kodo.Assigment.controller;
import com.kodo.Assigment.model.Submissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormSubmissionController {
    @PostMapping("/form/{formId}/submit")
    public void submitForm(Submissions submission) {

    }
}
