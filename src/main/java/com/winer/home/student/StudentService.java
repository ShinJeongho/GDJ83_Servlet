package com.winer.home.student;

import java.util.List;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	public List<StudentDTO> getStudents() {
		List<StudentDTO> students = null;
		try {
			students = studentDAO.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) {
		StudentDTO student = null;
		try {
			student = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			student = null;
		}
		return student;
	}

}
