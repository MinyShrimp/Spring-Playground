package shrimp.playground.member.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class AddResponseDto {

    private final String name;

    private final String email;

    private final Timestamp createOn;
}
