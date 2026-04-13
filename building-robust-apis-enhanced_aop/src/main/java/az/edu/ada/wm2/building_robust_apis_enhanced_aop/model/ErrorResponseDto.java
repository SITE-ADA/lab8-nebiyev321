package az.edu.ada.wm2.building_robust_apis_enhanced_aop.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorResponseDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
    private String message;
    private List<String> details;
}
