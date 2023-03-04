package shrimp.playground.member.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddRequest {

    @NotBlank
    private final String name;

    @Email
    @NotBlank
    private final String email;

    @NotBlank
    private final String password;

    @JsonCreator
    public AddRequest(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
