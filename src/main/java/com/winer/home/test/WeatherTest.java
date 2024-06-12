package com.winer.home.test;

import com.winer.home.weather.WeatherDAO;

public class WeatherTest {

	public static void main(String[] args) {
		WeatherDAO weatherDAO = new WeatherDAO();
		try {
			weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
