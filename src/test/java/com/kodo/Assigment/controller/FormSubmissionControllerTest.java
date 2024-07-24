package com.kodo.Assigment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodo.Assigment.model.FieldValues;
import com.kodo.Assigment.model.Form;
import com.kodo.Assigment.model.Submissions;
import com.kodo.Assigment.repository.FieldValuesRepository;
import com.kodo.Assigment.repository.FieldsRepository;
import com.kodo.Assigment.repository.FormRepository;
import com.kodo.Assigment.repository.SubmissionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormSubmissionController.class)
class FormSubmissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubmissionsRepository submissionsRepository;

    @MockBean
    private FieldValuesRepository fieldValuesRepository;

    @MockBean
    private FormRepository formRepository;

    @MockBean
    private FieldsRepository fieldsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSubmitForm() throws Exception {
        Form form = new Form("Test Form", Collections.emptyList());
        Submissions submission = new Submissions();
        submission.setId(1);
        submission.setForm(form);

        when(formRepository.findById(1L)).thenReturn(Optional.of(form));
        when(submissionsRepository.save(any(Submissions.class))).thenReturn(submission);

        mockMvc.perform(MockMvcRequestBuilders.post("/form/1/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(submission)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    @Test
    void testGetAllSubmissions() throws Exception {
        // Create the form and submissions
        Form form = new Form();
        form.setId(1L);
        form.setFormTitle("Test Form");
        Submissions submission = new Submissions();
        submission.setId(1);
        submission.setForm(form);

        form.setSubmissions(Collections.singletonList(submission)); // Set the submissions list to the form

        // Mock the repository to return the form wrapped in an Optional
        when(formRepository.findById(1L)).thenReturn(Optional.of(form));

        mockMvc.perform(MockMvcRequestBuilders.get("/form/1/submissions"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L));
    }


    @Test
    void testGetSubmissionById() throws Exception {
        Submissions submission = new Submissions();
        submission.setId(1);

        when(submissionsRepository.getById(1)).thenReturn(submission);

        mockMvc.perform(MockMvcRequestBuilders.get("/submissions/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}
