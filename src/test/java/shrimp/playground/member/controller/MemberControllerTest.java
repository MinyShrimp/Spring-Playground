package shrimp.playground.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import shrimp.playground.member.entity.MemberEntity;
import shrimp.playground.member.repository.MemberRepository;

import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @Nested
    @DisplayName("회원 가입 테스트")
    class CreateTest {

        @Test
        @DisplayName("정상 호출")
        void createTestOk() throws Exception {

            String content = "{\"name\": \"새우\", \"email\": \"ksk7584@gmail.com\", \"password\": \"qwer1234!\"}";

            mockMvc.perform(post("/member/add")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name").value("새우"))
                    .andExpect(jsonPath("$.email").value("ksk7584@gmail.com"))
                    .andDo(document("post-addMember",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            requestFields(
                                    fieldWithPath("name").description("회원 이름"),
                                    fieldWithPath("email").description("이메일"),
                                    fieldWithPath("password").description("비밀 번호")
                            ),
                            responseFields(
                                    fieldWithPath("name").description("회원 이름"),
                                    fieldWithPath("email").description("이메일"),
                                    fieldWithPath("createOn").description("생성 시간")
                            )
                    ));
        }
    }

    @Nested
    @DisplayName("회원 탈퇴 테스트")
    class DeleteTest {
        @Test
        @DisplayName("정상 호출")
        void deleteTestOk() throws Exception {

            MemberEntity member = memberRepository.save(
                    new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!")
            );
            String content = "{\"memberId\": \"" + member.getId() + "\"}";

            mockMvc.perform(delete("/member")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.memberName").value("새우"))
                    .andExpect(jsonPath("$.message").value("good bye [새우] ..."))
                    .andDo(document("delete-member",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            requestFields(
                                    fieldWithPath("memberId").description("회원 ID")
                            ),
                            responseFields(
                                    fieldWithPath("memberName").description("회원 이름"),
                                    fieldWithPath("message").description("메시지")
                            )
                    ));
        }

        @Test
        @DisplayName("예외 호출 - 회원 가입 X")
        void deleteTestThrow1() throws Exception {
            String content = "{\"memberId\": \"" + UUID.randomUUID() + "\"}";

            mockMvc.perform(delete("/member")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("회원을 찾을 수 없습니다."))
                    .andDo(document("delete-member-ex-noMember",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            requestFields(
                                    fieldWithPath("memberId").description("회원 ID")
                            ),
                            responseFields(
                                    fieldWithPath("message").description("예외 메시지")
                            )
                    ));
        }

        @Test
        @DisplayName("예외 호출 - 이미 탈퇴한 회원")
        void deleteTestThrow2() throws Exception {
            MemberEntity member = memberRepository.save(
                    new MemberEntity("새우", "ksk7584@gmail.com", "qwer1234!")
            );
            String content = "{\"memberId\": \"" + member.getId() + "\"}";
            memberRepository.delete(member);

            mockMvc.perform(delete("/member")
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("회원을 찾을 수 없습니다."))
                    .andDo(document("delete-member-ex-already",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            requestFields(
                                    fieldWithPath("memberId").description("회원 ID")
                            ),
                            responseFields(
                                    fieldWithPath("message").description("예외 메시지")
                            )
                    ));
        }
    }
}
