package com.azul.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookstoreApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkUnauthorizedResponse() throws Exception {
        mockMvc.perform(delete("http://localhost:8082/books/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void checkAuthorizationDoNotNeedResponse() throws Exception {
        mockMvc.perform(get("http://localhost:8082/books?page=0"))
                .andExpect(status().is2xxSuccessful());
    }

}
