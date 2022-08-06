package com.hp.gekko.ordermanagement.component;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.hp.gekko.ordermanagement.rest.HealthController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("ComponentTest")
// Only launch the rest context
@WebMvcTest(value = HealthController.class)
class HealthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthTest() throws Exception {
        mockMvc.perform(get("/service-quickstart/health"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void pingTest() throws Exception{
        mockMvc.perform(get("/ping"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
