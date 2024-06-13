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

		if (uri.equals("list")) {

			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp"); // jsp 경로명담기
		} else if (uri.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (uri.equals("delete")) {

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
