package com.kodo.Assigment;

import com.kodo.Assigment.model.Fields;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldsTest {

    @Test
    public void testField() {
        // Initialize the Fields object with sample data
        Fields field = new Fields("Sample Field", true, "text", "sampleValue", 1L);

        // Test the getters and setters of the Fields class
        assertEquals("Sample Field", field.getLabel(), "Label should match");
        assertEquals(true, field.getIsRequired(), "isRequired should match");
        assertEquals("text", field.getFieldType(), "FieldType should match");
        assertEquals("sampleValue", field.getValue(), "Value should match");
        assertEquals(1L, field.getId(), "ID should match");

        // Update values using setters
        field.setLabel("Updated Field");
        field.setIsRequired(false);
        field.setFieldType("number");
        field.setValue("updatedValue");
        field.setId(2L);

        // Test updated values
        assertEquals("Updated Field", field.getLabel(), "Updated label should match");
        assertEquals(false, field.getIsRequired(), "Updated isRequired should match");
        assertEquals("number", field.getFieldType(), "Updated FieldType should match");
        assertEquals("updatedValue", field.getValue(), "Updated value should match");
        assertEquals(2L, field.getId(), "Updated ID should match");
    }
}
