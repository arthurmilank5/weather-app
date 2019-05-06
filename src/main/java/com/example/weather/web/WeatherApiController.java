package com.example.weather.web;

import com.example.weather.integration.ows.Weather;
import com.example.weather.integration.ows.WeatherForecast;
import com.example.weather.integration.ows.WeatherService;
import com.example.weather.repo.ForecastCache;
import com.example.weather.repo.ForecastRepo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	private final WeatherService weatherService;
	private final ForecastRepo cacheService;

	public WeatherApiController(WeatherService weatherService, ForecastRepo cacheService) {
		this.weatherService = weatherService;
		this.cacheService = cacheService;
	}
	

	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeather(country, city);
	}
	

	@RequestMapping("/weekly/{country}/{city}")
	public WeatherForecast getWeatherForecast(@PathVariable String country,
			@PathVariable String city) {
		ForecastCache cache = this.cacheService.get(country, city);
		WeatherForecast result = null;
		if(cache == null) {
			result = this.weatherService.getWeatherForecast(country, city);
			this.cacheService.save(country, city, result);
			System.out.println("Generated cache to "+country+", "+city);
		}
		else {
			result = cache.getResult();
			System.out.println("Loaded cache to "+country+", "+city);
		}

		return result;
	}
	
}
