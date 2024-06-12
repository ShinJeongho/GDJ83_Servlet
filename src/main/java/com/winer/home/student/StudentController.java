package com.winer.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winer.home.Action;

public class StudentController {

	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();

	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public Action start(HttpServletRequest request) {
		// student뒤에 (uri)= (request)
		// list 가들어오면 학생 정보전체출력
		// add가 들어오면 학생 한명정보추가
		// delete가 들어오면 학생 한명 삭제
		// detail 학생 한명정보 출력
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);

		String method = request.getMethod();

		if (uri.equals("list")) {
			List<Student> ar = studentService.getStudents();
			request.setAttribute("list", ar);

			action.setPath("/WEB-INF/views/student/list.jsp");
		} else if (uri.equals("add")) {

			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터를 꺼내야 함");
				Student student = new Student();
				String name = request.getParameter("name");
				System.out.println(name);

				student.setName(name);
				student.setNum(Integer.parseInt(request.getParameter("num")));
				student.setAvg(Double.parseDouble(request.getParameter("avg")));

				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));

				String[] ch2 = request.getParameterValues("ch2");

				for (String s : ch2) {
					System.out.println(s);
				}

				action.setFlag(false);
				action.setPath("./list");

			} else {
				action.setPath("/WEB-INF/views/student/add.jsp");
			}
		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {
			Student student = this.studentService.makeStudent();
			request.setAttribute("s", student);
			action.setPath("/WEB-INF/views/student/detail.jsp");
		} else {

		}
		return action;
	}

}
