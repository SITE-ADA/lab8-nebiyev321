package az.edu.ada.wm2.resful_demo_jwt.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;

    private Long expiresIn;

}