package app.web.dto;

import app.user.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass // marked as final, cannot be inherited, cannot generate objects of this class
public class DtoMapper {

//    no business logic should be here
//    only mapping between entities and DTOs
    public static EditProfileRequest fromUser(User user) {
        return EditProfileRequest.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profilePictureUrl(user.getProfilePicture())
                .build();
    }

}
