package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequest (
        @NotBlank
        @Size(min = 6, max = 24, message = "Username must be between 6 and 24 characters")
        String username,

        @NotBlank
        @Size(min = 6, max = 6, message = "Username must be 6 characters")
        String password
) {
}
