package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Size(min = 1, max = 12)
    private String username;

    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @Size(min = 1, max = 12)
    @NotBlank
    private String nickname;

}
