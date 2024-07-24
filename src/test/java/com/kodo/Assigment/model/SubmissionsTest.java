package com.kodo.Assigment.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmissionsTest {

    @Test
    void testSubmissionsConstructorAndGetters() {
        int id = 1;
        Form form = new Form();
        List<FieldValues> fieldValues = Arrays.asList(new FieldValues());

        Submissions submissions = new Submissions(id);
        submissions.setForm(form);
        submissions.setFieldValues(fieldValues);

        assertEquals(id, submissions.getId());
        assertEquals(form, submissions.getForm());
        assertEquals(fieldValues, submissions.getFieldValues());
    }

    @Test
    void testSetters() {
        Submissions submissions = new Submissions();

        int id = 1;
        Form form = new Form();
        List<FieldValues> fieldValues = Arrays.asList(new FieldValues());

        submissions.setId(id);
        submissions.setForm(form);
        submissions.setFieldValues(fieldValues);

        assertEquals(id, submissions.getId());
        assertEquals(form, submissions.getForm());
        assertEquals(fieldValues, submissions.getFieldValues());
    }

    @Test
    void testEmptyConstructor() {
        Submissions submissions = new Submissions();
        assertNotNull(submissions);
    }

    @Test
    void testRelationshipWithForm() {
        Submissions submissions = new Submissions();
        Form form = new Form();
        form.setId(1L);

        submissions.setForm(form);

        assertEquals(form, submissions.getForm());
    }

    @Test
    void testRelationshipWithFieldValues() {
        Submissions submissions = new Submissions();
        FieldValues fieldValue = new FieldValues();
        fieldValue.setId(1);

        List<FieldValues> fieldValues = Arrays.asList(fieldValue);
        submissions.setFieldValues(fieldValues);

        assertEquals(fieldValues, submissions.getFieldValues());
    }
}
