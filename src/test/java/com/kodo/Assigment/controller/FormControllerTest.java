package com.kodo.Assigment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodo.Assigment.model.Fields;
import com.kodo.Assigment.model.Form;
import com.kodo.Assigment.repository.FieldsRepository;
import com.kodo.Assigment.repository.FormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormController.class)
class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FormRepository formRepository;

    @MockBean
    private FieldsRepository fieldsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateForm() throws Exception {
        Form form = new Form("Test Form", Collections.emptyList());
        when(formRepository.save(any(Form.class))).thenReturn(form);

        mockMvc.perform(MockMvcRequestBuilders.post("/form")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(form)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Test Form"));
    }

    @Test
    void testGetForms() throws Exception {
        Form form = new Form("Test Form", Collections.emptyList());
        when(formRepository.findAll()).thenReturn(Collections.singletonList(form));

        mockMvc.perform(MockMvcRequestBuilders.get("/form"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].formTitle").value("Test Form"));
    }

    @Test
    void testGetFormById() throws Exception {
        Form form = new Form("Test Form", Collections.emptyList());
        when(formRepository.findById(1L)).thenReturn(Optional.of(form));

        mockMvc.perform(MockMvcRequestBuilders.get("/form/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.formTitle").value("Test Form"));
    }
}
