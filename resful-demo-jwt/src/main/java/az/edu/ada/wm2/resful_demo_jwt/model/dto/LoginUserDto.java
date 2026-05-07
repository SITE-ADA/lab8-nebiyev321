package az.edu.ada.wm2.resful_demo_jwt.model.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;

    private String password;

}