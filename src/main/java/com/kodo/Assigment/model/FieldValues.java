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
    @ManyToOne(fetch = FetchType.LAZY)
    private Fields field;

    private long field_id_temp;
    private String field_value;

    public FieldValues(int id, Submissions submission, long field_id_temp, String field_value) {
        this.id = id;
        this.submission = submission;
        this.field_id_temp = field_id_temp;
        this.field_value = field_value;
    }

    public long getField_id_temp() {
        return field_id_temp;
    }

    public void setField_id_temp(long field_Id) {
        this.field_id_temp = field_Id;
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

    public Fields getField() {
        return field;
    }

    public void setField(Fields field) {
        this.field = field;
    }

    public String getField_value() {
        return field_value;
    }

    public void setField_value(String field_value) {
        this.field_value = field_value;
    }
}
