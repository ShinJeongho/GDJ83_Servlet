package com.winer.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winer.home.Action;

public class WeatherController {

	private WeatherService ws;

	public WeatherController() {
		ws = new WeatherService();
	}

	public Action start(HttpServletRequest request) throws Exception {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1); // 마지막/이후의 1번부터 문자열 추출

		Action action = new Action(); // jsp 경로명담아서
		action.setFlag(true);
		// 메서드형식 반환
		String method = request.getMethod().toUpperCase();

		if (uri.equals("list")) {

			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp"); // jsp 경로명담기
		} else if (uri.equals("add")) {

			if (method.equals("POST")) {
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				String status = request.getParameter("status");
				int huminity = Integer.parseInt(request.getParameter("huminity"));
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setStatus(status);
				weatherDTO.setHuminity(huminity);

				ws.add(weatherDTO);

//				List<WeatherDTO> ar = ws.getWeathers(); // add하면 list표가사라진거해결 코드
//				request.setAttribute("list", ar); // 위아래 코드쓰면 테이블이 생김
				// action.setPath("/weather/list"); //절대경로
				action.setPath("./list"); // 상대경로 ./생략해도댐
				action.setFlag(false); // 리다이렉트로 내보낼거임
			} else {
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}

		} else if (uri.equals("delete")) {
			if (method.equals("POST")) {
				String num = request.getParameter("num");
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setNum(Long.parseLong(num));
				ws.delete(weatherDTO);
				action.setPath("./list");
				action.setFlag(false);

			}

		} else if (uri.equals("detail")) {
			// 누구를 꺼내올건가 파라미터꺼내기
			String num = request.getParameter("num"); // 파라미터 string
			WeatherDTO weatherDTO = new WeatherDTO(); // 객체초기화
			weatherDTO.setNum(Long.parseLong(num)); // num을 long으로 변환
			weatherDTO = ws.getDeatail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");

			} else {
				request.setAttribute("message", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}

		} else {

		}
		return action;
	}

}
