package eu.softcent.spring.controller;

import eu.softcent.spring.dto.StudentRequest;
import eu.softcent.spring.entity.Student;
import eu.softcent.spring.entity.ApiResponse;
import eu.softcent.spring.exception.NotFoundException;
import eu.softcent.spring.service.StudentService;
import eu.softcent.spring.utils.ApiFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping
  public ApiResponse getAllStudents() {
    final ApiResponse response = ApiResponse.build(studentService.getAllStudents(), "Students List", true, null);
    return response;
  }

  @PostMapping
  public ApiResponse saveStudent(@RequestBody @Valid StudentRequest studentRequest) {
    try {
      final Student student = studentService.saveStudent(studentRequest);
      final ApiResponse apiResponse = ApiResponse.build(student, "Student Saved Successfully", true, null);
      return apiResponse;
    } catch (Exception exception) {
      return ApiFeedback.onError(exception);
    }
  }

  @GetMapping("/{id}")
  public ApiResponse getStudent(@PathVariable @Valid int id) throws NotFoundException {
    final ApiResponse response = ApiResponse.build(studentService.getStudentById(id), "Student Found", true, null);
    return response;
  }

  @PutMapping("/{id}")
  public ApiResponse updateStudent(@RequestBody @Valid StudentRequest request, @PathVariable @Valid int id) throws NotFoundException {
    final ApiResponse response = ApiResponse.build(studentService.updateStudent(request, id), "Student updated", true, null);
    return response;
  }

  @DeleteMapping("/{id}")
  public ApiResponse deleteStudent(@PathVariable @Valid int id) throws NotFoundException {
    final ApiResponse response = ApiResponse.build(new Object(), "Student Deleted", studentService.deleteStudent(id), null);
    return response;
  }
}
