package az.edu.ada.wm2.building_robust_apis.controller;

import az.edu.ada.wm2.building_robust_apis.exception.StudentNotFoundException;
import az.edu.ada.wm2.building_robust_apis.model.Student;
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

    //WITHOUT ERROR HANDLING
    @PostMapping
    public Student create(@Valid @RequestBody Student s) {
        log.info("Creating student: {}", s);
        s.setId(UUID.randomUUID());
        //TODO
        log.info("Student created successfully");
        return s;
    }

    //WITH ERROR HANDLING
//    @PostMapping
//    public ResponseEntity<?> create(
//            @Valid @RequestBody Student student,
//            BindingResult result) {
//
//        if (result.hasErrors()) {
//            String errors = result.getAllErrors().stream()
//                    .map(ObjectError::getDefaultMessage)
//                    .collect(Collectors.joining("; "));
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        student.setId(UUID.randomUUID());
//        return ResponseEntity.ok(student);
//    }

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
