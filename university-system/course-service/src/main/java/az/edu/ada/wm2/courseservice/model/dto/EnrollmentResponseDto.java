package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDto {

    @Schema(description = "Enrollment id", example = "1")
    private Long id;

    @Schema(description = "Course id", example = "1")
    private Long courseId;

    @Schema(description = "Student id", example = "2")
    private Long studentId;

    @Schema(description = "Enrollment date", example = "2026-05-20")
    private LocalDate enrollmentDate;

    @Schema(description = "Response message", example = "Student enrolled successfully.")
    private String message;
}