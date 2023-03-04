package shrimp.playground.member.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteRequest {

    @NotBlank
    private final String memberId;

    @JsonCreator
    public DeleteRequest(
            @JsonProperty("memberId") String memberId
    ) {
        this.memberId = memberId;
    }
}
