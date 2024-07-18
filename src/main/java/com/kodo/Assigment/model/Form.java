package com.kodo.Assigment.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "form_table")
public class Form implements Serializable {
    private String formTitle;
    @OneToMany(mappedBy = "form", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Fields> fields = new ArrayList<>();
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long formID;

    public Form() {

    }

    public String getFormTitle() {
        return formTitle;
    }

    public Form(String formTitle, List<Fields> fields, long formID) {
        this.formTitle = formTitle;
        this.fields = fields;
        this.formID = formID;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}
