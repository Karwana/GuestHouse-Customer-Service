package org.nackademin.guesthousecustomerservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void return201WhenCreatingCustomer() throws Exception {
        String validCustomerJson = """
                   {
                                       "name": "Karwan Ali",
                                       "email": "karwan@integrationtest.com",
                                       "phoneNumber": "0701234567"
                                   }
                """;
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validCustomerJson))
                        .andExpect(status().isCreated());


    }

    @Test
    void return400WhenCreatingInvalidCustomer() throws Exception {
        String invalidCustomerJson = """
                   {
                                       "name": "",
                                       "email": "email@email.com",
                                       "phoneNumber": "0701234567"
                                   }
                """;
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCustomerJson))
                        .andExpect(status().isBadRequest());
    }

    @Test
    void return404WhenGettingNonExistingCustomer() throws Exception {
        mockMvc.perform(get("/api/customers/99999"))
                .andExpect(status().isNotFound());
    }

}
