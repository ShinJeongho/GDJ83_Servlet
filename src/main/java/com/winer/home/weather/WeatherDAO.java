package com.winer.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

	// getWeathers 메서드 : 파일에 날씨정보들을 읽어와서 파씽한 후 에 DTO에담아서 리턴
	// 서비스에서 getWeathers 호출하면 WeatherDAO가 옴
	// 여기선 데이터를 꺼내오거나 집어넣거나
	// service는 전처리나 후처리용

	public List<WeatherDTO> getWeathers() throws Exception {
		List<WeatherDTO> weatherlist = new ArrayList<WeatherDTO>();

		File file = new File("C:\\study\\weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}

			s = s.replace(",", "-");
			String[] items = s.split("-");

			WeatherDTO weather = new WeatherDTO();
			weather.setNum(Long.parseLong(items[0].trim()));
			weather.setCity(items[1].trim());
			weather.setGion(Double.parseDouble(items[2].trim()));
			weather.setStatus(items[3].trim());
			weather.setHuminity(Integer.parseInt(items[4].trim()));
			weatherlist.add(weather);

		}
		br.close();
		fr.close();

		return weatherlist;

	}
}
