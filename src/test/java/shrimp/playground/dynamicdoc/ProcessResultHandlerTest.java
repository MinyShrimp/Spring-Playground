package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ProcessResultHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProcessResultHandler handler;

    @Test
    void handlerTest() throws Exception {

        String content = "{\"name\": \"새우\", \"email\": \"ksk7584@gmail.com\", \"password\": \"qwer1234!\"}";

        mockMvc.perform(post("/member/add")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("새우"))
                .andExpect(jsonPath("$.email").value("ksk7584@gmail.com"))
                .andDo(handler);
    }
}