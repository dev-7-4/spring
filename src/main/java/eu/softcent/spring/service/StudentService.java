package eu.softcent.spring.service;

import eu.softcent.spring.dto.StudentRequest;
import eu.softcent.spring.entity.Student;
import eu.softcent.spring.exception.NotFoundException;
import eu.softcent.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student saveStudent(StudentRequest request) {
    final Student student = Student.build(0,
            request.getName(),
            request.getEmail(),
            request.getSubject(),
            request.getDepartment());
    return studentRepository.save(student);
  }

  public Student getStudentById(final int id) throws NotFoundException {
    final Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
    return student;
  }

  public Student updateStudent(final StudentRequest request, final int id) throws NotFoundException {
    final Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
    student.setName(request.getName());
    student.setEmail(request.getEmail());
    student.setSubject(request.getSubject());
    student.setDepartment(request.getDepartment());
    return studentRepository.save(student);
  }

  public Boolean deleteStudent(int id) throws NotFoundException {
    if (studentRepository.findById(id).orElse(null) == null) {
      throw new NotFoundException();
    }
    studentRepository.deleteById(id);
    return studentRepository.findById(id).orElse(null) == null;
  }
}
