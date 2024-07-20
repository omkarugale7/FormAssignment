package com.kodo.Assigment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "fields_table")
public class Fields implements Serializable {
    @Column(name = "label_name")
    private String label;
    private Boolean isRequired;
    private String fieldType;
    @Column(name = "field_value")
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Form form;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Fields(){}

    public Fields(String label, Boolean isRequired, String fieldType, String value, Long id) {
        this.label = label;
        this.isRequired = isRequired;
        System.out.println(isRequired);
        this.fieldType = fieldType;
        this.value = value;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean required) {
        isRequired = required;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
        System.out.println("hello I am is here");
        System.out.println(form.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}