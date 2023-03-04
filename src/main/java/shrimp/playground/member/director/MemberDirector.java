package shrimp.playground.member.director;

import shrimp.playground.member.dto.AddRequestDto;
import shrimp.playground.member.dto.AddResponseDto;
import shrimp.playground.member.entity.MemberEntity;

public class MemberDirector {

    private MemberDirector() {
    }

    public static MemberEntity addRequestToEntity(AddRequestDto dto) {
        return new MemberEntity(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        );
    }

    public static AddResponseDto entityToAddResponse(MemberEntity entity) {
        return new AddResponseDto(
                entity.getName(),
                entity.getEmail(),
                entity.getCreateOn()
        );
    }
}
