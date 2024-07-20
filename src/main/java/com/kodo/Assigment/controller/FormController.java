package com.kodo.Assigment.controller;

import com.kodo.Assigment.model.Fields;
import com.kodo.Assigment.model.Form;
import com.kodo.Assigment.repository.FieldsRepository;
import com.kodo.Assigment.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {
    @Autowired
    private FormRepository formRepository;
    @Autowired
    private FieldsRepository fieldsRepository;
    @PostMapping("/form")
    public String createForm(@RequestBody Form form) {
        formRepository.save(form);
        for (Fields field : form.getFields()) {
            field.setForm(form);
            fieldsRepository.save(field);
            System.out.println(field.getIsRequired());
        }
        return form.getFormTitle();
    }
    @GetMapping("/form")
    public List<Form> getForms() {
        return formRepository.findAll();
    }
    @GetMapping("/form/{formId}")
    public Form getFormById(@PathVariable long formId) {
        return formRepository.findById(formId).get();
    }

}
