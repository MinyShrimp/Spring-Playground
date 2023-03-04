package shrimp.playground.member.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shrimp.playground.member.director.MemberDirector;
import shrimp.playground.member.dto.AddRequestDto;
import shrimp.playground.member.dto.AddResponseDto;
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
            @NotBlank @RequestParam String memberId
    ) {
        memberService.deleteMember(memberId);
        return "good bye..";
    }
}
