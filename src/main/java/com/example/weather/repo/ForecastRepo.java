package com.example.weather.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.weather.integration.ows.WeatherForecast;

@Service
public class ForecastRepo {

	private List<ForecastCache> cacheRepo;

	public ForecastRepo() {
		this.cacheRepo = new ArrayList<ForecastCache>();
	}
	
	public ForecastCache get(String country, String city) {
		return cacheRepo.stream().filter(e -> 
					e.getCountry().equals(country) 
					&& e.getCity().equals(city)
				).findFirst().orElse(null);
	}

	public void save(String country, String city, WeatherForecast result) {
		cacheRepo.add(new ForecastCache(country, city, result));
	}
	
}
