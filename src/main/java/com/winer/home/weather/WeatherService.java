package com.winer.home.weather;

import java.util.List;

public class WeatherService {
	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;

	}

}
