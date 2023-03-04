package shrimp.playground.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shrimp.playground.member.director.MemberDirector;
import shrimp.playground.member.dto.AddRequestDto;
import shrimp.playground.member.entity.MemberEntity;
import shrimp.playground.member.repository.MemberRepository;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberEntity addMember(
            AddRequestDto dto
    ) {
        return memberRepository.save(
                MemberDirector.addRequestToEntity(dto)
        );
    }

    @Transactional
    public void deleteMember(
            String memberId
    ) {
        Optional<MemberEntity> findMember = memberRepository.findById(UUID.fromString(memberId));
        findMember.ifPresent(memberRepository::delete);
    }
}
