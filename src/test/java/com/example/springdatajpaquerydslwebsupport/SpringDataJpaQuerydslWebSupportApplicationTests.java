package com.example.springdatajpaquerydslwebsupport;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringDataJpaQuerydslWebSupportApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    public void queryAll() {

        mockMvc.perform(get("/students"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$", hasSize(3)))
               .andDo(print());
    }

    @Test
    @SneakyThrows
    void querySingleValue() {

        mockMvc.perform(get("/students?major=sword"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$", hasSize(1)))
               .andExpect(jsonPath("$[0].name").value("Arthur"))
               .andExpect(jsonPath("$[0].major").value("sword"))
               .andDo(print());
    }


    @Test
    @SneakyThrows
    void queryMultiValue() {

        mockMvc.perform(get("/students?major=sword&major=magic"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].name").value("Arthur"))
               .andExpect(jsonPath("$[0].major").value("sword"))
               .andExpect(jsonPath("$[1].name").value("Merlin"))
               .andExpect(jsonPath("$[1].major").value("magic"))
               .andDo(print());
    }
}
