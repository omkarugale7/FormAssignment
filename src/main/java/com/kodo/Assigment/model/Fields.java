package com.kodo.Assigment.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "fields_table")
public class Fields implements Serializable {
    private String label;
    private Boolean isRequired;
    private String fieldType;
    private String value;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id")
    private Form form;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Fields(){}

    public Fields(String label, Boolean isRequired, String fieldType, String value, com.kodo.Assigment.model.Form form, Long id) {
        this.label = label;
        this.isRequired = isRequired;
        this.fieldType = fieldType;
        this.value = value;
        this.form = form;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}