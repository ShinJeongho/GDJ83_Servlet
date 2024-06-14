package com.winer.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
		List<WeatherDTO> ar = this.getWeathers();
		StringBuffer stringBuffer = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		stringBuffer.append(ca.getTimeInMillis()); // 번호 안겹치게 하는 코드
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());

		File file = new File("C:\\study\\weather.txt");

		FileWriter fileWriter = new FileWriter(file, true);

		fileWriter.write(stringBuffer.toString() + "\r\n");
		fileWriter.flush();

		fileWriter.close();

	}

	public void delete(WeatherDTO weatherDTO) throws Exception {
		// 리스트 불러와서 지우려고하는 num과 일치하는 것을 리스트에서 삭제
		// 남아있는 리스트를 파일에 다시 저장 지우고나서 리스트로 다시돌아가게
		List<WeatherDTO> ar = this.getWeathers();
		File file = new File("C:\\study\\weather.txt");
		FileWriter fileWriter = new FileWriter(file);

		for (WeatherDTO weather : ar) {
			if (weather.getNum() != weatherDTO.getNum()) {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(weather.getNum());
				stringBuffer.append("-");
				stringBuffer.append(weather.getCity());
				stringBuffer.append("-");
				stringBuffer.append(weather.getGion());
				stringBuffer.append("-");
				stringBuffer.append(weather.getStatus());
				stringBuffer.append("-");
				stringBuffer.append(weather.getHuminity());
				fileWriter.write(stringBuffer.toString() + "\r\n");

			}
		}
		fileWriter.flush();
		fileWriter.close();
	}

	public void update(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		File file = new File("C:\\study\\weather.txt");
		FileWriter fileWriter = new FileWriter(file);

		for (WeatherDTO weather : ar) {
			if (weather.getNum() == weatherDTO.getNum()) {
				weather.setCity(weatherDTO.getCity());
				weather.setGion(weatherDTO.getGion());
				weather.setStatus(weatherDTO.getStatus());
				weather.setHuminity(weatherDTO.getHuminity());
			}
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(weather.getNum());
			stringBuffer.append("-");
			stringBuffer.append(weather.getCity());
			stringBuffer.append("-");
			stringBuffer.append(weather.getGion());
			stringBuffer.append("-");
			stringBuffer.append(weather.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(weather.getHuminity());
			fileWriter.write(stringBuffer.toString() + "\r\n");
		}
		fileWriter.flush();
		fileWriter.close();
	}

}