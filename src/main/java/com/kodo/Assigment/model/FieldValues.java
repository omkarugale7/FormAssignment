package com.kodo.Assigment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class FieldValues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Submissions submission;
    private int field_id;
    private String field_value;

    public FieldValues(int id, int field_id, String field_value) {
        this.id = id;
        this.field_id = field_id;
        this.field_value = field_value;
    }

    public FieldValues() {
    }

    public Submissions getSubmission() {
        return submission;
    }

    public void setSubmission(Submissions submission) {
        this.submission = submission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public String getField_value() {
        return field_value;
    }

    public void setField_value(String field_value) {
        this.field_value = field_value;
    }
}
