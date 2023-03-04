package shrimp.playground.member.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteResponse {

    private final String memberName;
    
    private final String message;
}
