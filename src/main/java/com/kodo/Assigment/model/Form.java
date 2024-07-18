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
    @Column(name = "ID")
    private long id;

    public Form() {

    }

    public String getFormTitle() {
        return formTitle;
    }

    public Form(String formTitle, List<Fields> fields ) {
        this.formTitle = formTitle;
        this.fields = fields;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}
