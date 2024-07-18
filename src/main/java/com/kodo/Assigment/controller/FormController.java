package com.kodo.Assigment.controller;

import com.kodo.Assigment.model.Form;
import com.kodo.Assigment.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {
    @Autowired
    private FormRepository formRepository;
    @PostMapping("/form")
    public String createForm(@RequestBody Form form) {
        formRepository.save(form);
             return form.getFormTitle();
    }
}
