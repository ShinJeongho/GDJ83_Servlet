package com.winer.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {

	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			Student student = new Student();

			student.setNum(i + 1);
			student.setName("name" + i);
			student.setAvg(random.nextInt(100) + random.nextDouble());

			ar.add(student);
		}
		return ar;
	}

	public Student makeStudent() {
		Student student = new Student();
		student.setNum(1);
		student.setName("winter");
		student.setAvg(56.32);
		return student;
	}

}
