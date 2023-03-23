package com.gmail.masha.weatherlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.masha.weatherlab.dto.WeatherDto;
import com.gmail.masha.weatherlab.models.Weather;
import com.gmail.masha.weatherlab.services.WeatherClient;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@SpringBootApplication
public class WeatherLabApplication {

	private final WeatherClient weatherClient;


	@Autowired
	public WeatherLabApplication(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(WeatherLabApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk";

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "8eb430aeb3mshb9a80249d052e79p1ea706jsn5db0bf8e8f25");
		headers.set("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);


		ResponseEntity<WeatherDto> response = restTemplate.exchange(
				url, HttpMethod.GET, request, WeatherDto.class);

//WeatherDto weatherDto = restTemplate.getForObject(url, WeatherDto.class, requestEntity);
	//	ResponseEntity<WeatherDto> responseEntity = restTemplate.exchange(requestEntity, WeatherDto.class);
	//	WeatherDto weatherDto = responseEntity.getBody();
		System.out.println(response.getBody());
		WeatherDto weatherDto = response.getBody();
		System.out.println(weatherDto);



	//	Weather weather = new Weather();
	//	weather.setName(ob);


	//	String response = restTemplate.getForObject(url, String.class, map);
	//	System.out.println(response);
/*		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk"))
				.header("X-RapidAPI-Key", "8eb430aeb3mshb9a80249d052e79p1ea706jsn5db0bf8e8f25")
				.header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
*/
	}




/*	@Scheduled(fixedDelay = 1000)
	public void checkWeather() {
		// go to the api
		Weather weather = weatherClient.goToWeatherApi();

		// save into DB
	}
*/
}
