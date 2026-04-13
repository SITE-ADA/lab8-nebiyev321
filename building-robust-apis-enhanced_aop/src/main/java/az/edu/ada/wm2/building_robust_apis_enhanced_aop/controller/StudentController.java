package az.edu.ada.wm2.building_robust_apis_enhanced_aop.controller;

import az.edu.ada.wm2.building_robust_apis_enhanced_aop.exception.StudentNotFoundException;
import az.edu.ada.wm2.building_robust_apis_enhanced_aop.model.Student;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    private final UUID MISSING_ID_TO_REMOVE
            = UUID.fromString("e2e4ba34-2861-417f" +
                                    "-940c-1060020783e1");

    @GetMapping
    public List<Student> getAll() {
        return List.of();
    }

    @PostMapping
    public Student create(@Valid @RequestBody Student s) {
        s.setId(UUID.randomUUID());
        //TODO
        return s;
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable UUID id) {
        if(MISSING_ID_TO_REMOVE.equals(id)){
            throw new StudentNotFoundException("Student not found with id" + id);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        if(MISSING_ID_TO_REMOVE.equals(id)){
            throw new StudentNotFoundException("Student not found with id" + id);
        }
    }


}
