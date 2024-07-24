package com.kodo.Assigment;

import com.kodo.Assigment.model.FieldValues;
import com.kodo.Assigment.model.Fields;
import com.kodo.Assigment.model.Submissions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FieldValuesTest {

    private FieldValues fieldValues;
    private Submissions submission;
    private Fields field;

    @BeforeEach
    public void setUp() {
        // Initialize objects before each test
        submission = new Submissions(1);
        field = new Fields("Sample Field", true, "text", "sampleValue", 1L);
        fieldValues = new FieldValues(1, submission, 1L, "sampleValue");
    }

    @Test
    public void testGettersAndSetters() {
        Submissions submission = new Submissions();
        Fields field = new Fields();
        field.setId(1L);
        field.setLabel("Test Field");

        FieldValues fieldValues = new FieldValues();
        fieldValues.setId(1);
        fieldValues.setSubmission(submission);
        fieldValues.setField(field);
        fieldValues.setField_id_temp(1L);
        fieldValues.setField_value("Test Value");

        // Assert fieldValues properties
        assertEquals(1, fieldValues.getId());
        assertEquals(submission, fieldValues.getSubmission());
        assertEquals(field, fieldValues.getField());
        assertEquals(1L, fieldValues.getField_id_temp());
        assertEquals("Test Value", fieldValues.getField_value());
    }

    @Test
    public void testFieldValuesConstructor() {
        // Test constructor with parameters
        FieldValues fieldValuesWithParams = new FieldValues(1, submission, 1L, "sampleValue");

        assertEquals(1, fieldValuesWithParams.getId(), "ID should be 1");
        assertEquals(submission, fieldValuesWithParams.getSubmission(), "Submission should match");
        assertEquals(1L, fieldValuesWithParams.getField_id_temp(), "Field ID Temp should be 1L");
        assertEquals("sampleValue", fieldValuesWithParams.getField_value(), "Field value should be 'sampleValue'");
    }
}
