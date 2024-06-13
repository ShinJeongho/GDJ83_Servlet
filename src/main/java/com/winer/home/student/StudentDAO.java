package com.winer.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	public List<StudentDTO> getStudents() throws Exception {
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();

		File file = new File("C:\\study\\student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			String[] sl = s.split("-");

			StudentDTO student = new StudentDTO();
			student.setNum(Integer.parseInt(sl[0].trim()));
			student.setName(sl[1].trim());
//			student.setKor(Integer.parseInt(sl[2].trim()));
//			student.setEng(Integer.parseInt(sl[3].trim()));
//			student.setMath(Integer.parseInt(sl[4].trim()));
//			student.setTotal(Integer.parseInt(sl[5].trim()));
			student.setAvg(Double.parseDouble(sl[6].trim()));
			studentList.add(student);

		}
		br.close();
		fr.close();

		return studentList;

	}

	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> studentList = this.getStudents();// 현재 객체의 getstudnet호출해서 모든학생정보가져옴

		for (StudentDTO student : studentList) { // studentList에 있는 모든 StudentDTO순회
			if (student.getNum() == studentDTO.getNum()) {
				return student; // 현재순회중인 student의 num과 입력파라미터로받은 studentDTO의 num이 같으면
			}
		}
		return null; // 요청한 학생번호에 해당하는 학생이 없음을 알려줌
	}

}
