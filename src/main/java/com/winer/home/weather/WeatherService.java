package com.winer.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {

	private StringBuffer sb;

	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울   , 29.3 - 맑음 -  60");
		this.sb.append("-부산   , 33.6 - 흐림 -  90");
		this.sb.append("-제주   , 26.5 - 눈 -  30");
		this.sb.append("-광주   , 10.6 - 태풍 -  80");
	}
	// 각 url에 맞는 jsp로 연결 /weather/list가 들어오면 서비스에 getWeatheres실행

	public List<WeatherDTO> getWeathers() {
		String data = this.sb.toString();
		data = data.replace(",", "-");

		StringTokenizer st = new StringTokenizer(data, "-");
		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (st.hasMoreTokens()) {
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setCity(st.nextToken().trim());
			weatherDTO.setGion(Double.parseDouble(st.nextToken().trim()));
			weatherDTO.setStatus(st.nextToken().trim());
			weatherDTO.setHuminity(Integer.parseInt(st.nextToken().trim()));
			ar.add(weatherDTO);
		}
		return ar;
	}

}
