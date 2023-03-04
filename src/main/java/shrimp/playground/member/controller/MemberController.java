package shrimp.playground.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shrimp.playground.member.director.MemberDirector;
import shrimp.playground.member.dto.AddRequestDto;
import shrimp.playground.member.dto.AddResponseDto;
import shrimp.playground.member.dto.DeleteRequest;
import shrimp.playground.member.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/add")
    public AddResponseDto addMember(
            @Valid @RequestBody AddRequestDto dto
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
