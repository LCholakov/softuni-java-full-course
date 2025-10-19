package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import main.model.House;
import main.model.WizardAlignment;
import org.hibernate.validator.constraints.URL;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank
    @Size(min = 6, max = 12)
    private String username ; // length [6 ; // 12] characters, not empty/blank text

    @NotBlank
//    stackoverflow idea to use long won't work with leading zeros => easier ot just use regex
    @Pattern(regexp = "\\d{6}")
    private String password ; // exactly 6 characters, must include only digits, not empty/blank text

    @NotBlank
    @URL
    private String avatarUrl ; // must be a valid URL, not empty/blank text

    @NotNull
    private House house ; // must be valid House enum value, not null

    @NotNull
    private WizardAlignment alignment ; // must be valid WizardAlignment enum value, not null

}
