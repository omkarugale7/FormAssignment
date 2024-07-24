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
        // Test getters
        assertEquals(1, fieldValues.getId(), "ID should be 1");
        assertEquals(submission, fieldValues.getSubmission(), "Submission should match");
        assertEquals(1L, fieldValues.getField_id_temp(), "Field ID Temp should be 1L");
        assertEquals("sampleValue", fieldValues.getField_value(), "Field value should be 'sampleValue'");
        assertEquals(field, fieldValues.getField(), "Field should match");

        // Test setters
        fieldValues.setId(2);
        fieldValues.setField_id_temp(2L);
        fieldValues.setField_value("newValue");
        fieldValues.setField(new Fields("New Field", false, "number", "newValue", 2L));

        assertEquals(2, fieldValues.getId(), "Updated ID should be 2");
        assertEquals(2L, fieldValues.getField_id_temp(), "Updated Field ID Temp should be 2L");
        assertEquals("newValue", fieldValues.getField_value(), "Updated field value should be 'newValue'");
        assertNotNull(fieldValues.getField(), "Field should not be null");
        assertEquals("New Field", fieldValues.getField().getLabel(), "Updated field label should be 'New Field'");
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
