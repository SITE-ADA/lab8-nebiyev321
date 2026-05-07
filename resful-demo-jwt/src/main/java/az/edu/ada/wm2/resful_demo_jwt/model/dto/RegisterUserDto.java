package az.edu.ada.wm2.resful_demo_jwt.model.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;
}