package cmtproject.comento.auth.dto;

import cmtproject.comento.auth.entity.User;
import lombok.Getter;

@Getter
public class AuthResponseDTO {

    private Long userId;

    private String username;

    public AuthResponseDTO(User user) {
        this.username = user.getUsername();
        this.userId = user.getUserId();

    }
}