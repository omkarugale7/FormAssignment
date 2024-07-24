package com.kodo.Assigment.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormTest {

    @Test
    void testFormConstructorAndGetters() {
        String formTitle = "Test Form";
        List<Fields> fields = new ArrayList<>();
        long id = 1L;

        Form form = new Form(formTitle, fields);
        form.setId(id);

        assertEquals(formTitle, form.getFormTitle());
        assertEquals(fields, form.getFields());
        assertEquals(id, form.getId());
    }

    @Test
    void testSetters() {
        Form form = new Form();

        String formTitle = "Test Form";
        List<Fields> fields = new ArrayList<>();
        long id = 1L;
        List<Submissions> submissions = Arrays.asList(new Submissions());

        form.setFormTitle(formTitle);
        form.setFields(fields);
        form.setId(id);
        form.setSubmissions(submissions);

        assertEquals(formTitle, form.getFormTitle());
        assertEquals(fields, form.getFields());
        assertEquals(id, form.getId());
        assertEquals(submissions, form.getSubmissions());
    }

    @Test
    void testEmptyConstructor() {
        Form form = new Form();
        assertNotNull(form);
    }

    @Test
    void testRelationshipWithFields() {
        Form form = new Form();
        Fields field = new Fields();
        field.setId(1L);

        List<Fields> fields = Arrays.asList(field);
        form.setFields(fields);

        assertEquals(fields, form.getFields());
    }

    @Test
    void testRelationshipWithSubmissions() {
        Form form = new Form();
        Submissions submission = new Submissions();
        submission.setId(1);

        List<Submissions> submissions = Arrays.asList(submission);
        form.setSubmissions(submissions);

        assertEquals(submissions, form.getSubmissions());
    }
}
