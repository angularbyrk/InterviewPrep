package com.cenit.exc;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cenit.exc.student.model.Student;
import com.cenit.exc.student.repository.StudentRepository;
import com.cenit.exc.student.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@Autowired
	StudentService studentService;

	@MockBean
	StudentRepository repo;

	@Test
	public void getAllStudents() {
		Student s1 = new Student(1, "s1");
		Student s2 = new Student();
		List<Student> list = Stream.of(s1, s2).toList();

		when(repo.findAll()).thenReturn(list).thenReturn(list).thenReturn(null);

		assertEquals(studentService.getAllStudents().size(), 2);
		assertEquals(studentService.getAllStudents().get(0).getId(), s1.getId());
		assertNull(studentService.getAllStudents());

	}

	@Test
	public void getStudentById() {
		Student s1 = new Student(1, "s1");
		when(repo.findById(1)).thenReturn(Optional.of(s1)).thenReturn(null);
		assertEquals(studentService.getStudentById(1).get(), s1);
		assertNull(studentService.getStudentById(1));
	}

	@Test
	public void save() {
		Student s1 = new Student(1, "s1");
		when(repo.save(any())).thenReturn(s1);
		assertEquals(studentService.save(s1), s1);
	}

	@Test
	public void update() {
		Student s1 = new Student(1, "s1");
		when(repo.save(any())).thenReturn(s1);
		assertEquals(studentService.update(s1), s1);
	}

	@Test
	public void deleteById() {
		doNothing().when(repo).deleteById(any());
		studentService.deleteById(1);
		verify(repo, times(1)).deleteById(any());
	}

}
