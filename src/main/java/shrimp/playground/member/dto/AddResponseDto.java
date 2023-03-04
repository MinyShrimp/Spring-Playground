package shrimp.playground.member.dto;

import lombok.Getter;
import shrimp.playground.member.entity.MemberEntity;

import java.sql.Timestamp;

@Getter
public class AddResponseDto {

    private final String name;

    private final String email;

    private final Timestamp createOn;

    public AddResponseDto(
            MemberEntity entity
    ) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.createOn = entity.getCreateOn();
    }
}
