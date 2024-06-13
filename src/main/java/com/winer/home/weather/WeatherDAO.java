package com.winer.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

	// getWeathers 메서드 : 파일에 날씨정보들을 읽어와서 파씽한 후 에 DTO에담아서 리턴
	// 서비스에서 getWeathers 호출하면 WeatherDAO가 옴
	// 여기선 데이터를 꺼내오거나 집어넣거나
	// service는 전처리나 후처리용

	// 파일에서 전체를꺼내오는
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

	// detail

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers(); // 번호가 일치하는애 찾기

		WeatherDTO result = null;

		for (WeatherDTO weather : ar) {
			if (weather.getNum() == weatherDTO.getNum()) {
				result = weather;

				break;

			}
		}
		return result;
	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		// 도시명-기온-상태-습도

		File file = new File("C:\\study\\weather.txt"); // 경로파일 지정
		FileWriter fw = new FileWriter(file, true); // 쓸때 기존파일에 덮어쓰기

		List<WeatherDTO> weatherList = this.getWeathers(); // 파일에서 기존날씨목록 가져와서 DTO형태변환
		weatherDTO.setNum(weatherList.size() + 1);// DTO객체에 넘버부여

		String data = weatherDTO.getNum() + "," + weatherDTO.getCity() + "-" + weatherDTO.getGion() + "-"
				+ weatherDTO.getStatus() + "-" + weatherDTO.getHuminity();

		fw.write(data);
		fw.close();

	}

}