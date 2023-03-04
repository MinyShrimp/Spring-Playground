package shrimp.playground.member.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {
        String contents = "{\"name\": \"김회민\", \"email\": \"ksk7584@gmail.com\", \"password\": \"qwer1234!\"}";

        this.mockMvc.perform(post("/member/add")
                        .content(contents)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value("ksk7584@gmail.com"))
                .andDo(document("post-addMember",
                        requestFields(
                                fieldWithPath("name").description("회원 이름"),
                                fieldWithPath("email").description("이메일"),
                                fieldWithPath("password").description("비밀 번호")
                        )
                ));
    }

    @Test
    void delete() throws Exception {
        
    }
}
