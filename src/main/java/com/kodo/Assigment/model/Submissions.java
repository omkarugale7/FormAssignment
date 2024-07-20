package com.kodo.Assigment.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Submissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;
    @OneToMany(mappedBy = "submission")
    private List<FieldValues> fieldValues;
    public Submissions(int id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Submissions() {
    }

    public List<FieldValues> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<FieldValues> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
