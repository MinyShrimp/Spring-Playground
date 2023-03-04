package shrimp.playground.member.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Getter
@RequiredArgsConstructor
public class AddResponse {

    private final String name;

    private final String email;

    private final Timestamp createOn;
}
