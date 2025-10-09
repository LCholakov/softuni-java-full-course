package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

//from registration screen, get data to controller
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
        @NotBlank
        @Size(min = 6, max = 24, message = "Username must be between 6 and 24 characters")
        private String username;

        @NotBlank
        @Size(min = 6, max = 6, message = "Password must be 6 characters")
        private String password;

        @NotNull
        private Country country;
}