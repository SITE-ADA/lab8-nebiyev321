package az.edu.ada.wm2.building_robust_apis.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Student {
    private UUID id;

    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must be valid")

    private String email;
    @Pattern(regexp = "^(\\+994|0)(50|51|55|70|77)[0-9]{7}$", message = "Phone number must be a valid Azerbaijani number")

    private String phoneNumber;
    @NotNull(message = "Enrollment date is required")
    @PastOrPresent(message = "Enrollment date cannot be in the future")
    private LocalDate enrollmentDate;

}
