package shrimp.playground.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shrimp.playground.member.director.MemberDirector;
import shrimp.playground.member.dto.request.AddRequest;
import shrimp.playground.member.dto.request.DeleteRequest;
import shrimp.playground.member.dto.response.AddResponse;
import shrimp.playground.member.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/add")
    public AddResponse addMember(
            @Valid @RequestBody AddRequest dto
    ) {
        return MemberDirector.entityToAddResponse(
                memberService.addMember(dto)
        );
    }

    @DeleteMapping
    public String deleteMember(
            @Valid @RequestBody DeleteRequest dto
    ) {
        String name = memberService.deleteMember(dto.getMemberId());
        return "good bye [" + name + "] ...";
    }
}
