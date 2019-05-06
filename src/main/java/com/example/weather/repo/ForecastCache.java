package com.example.weather.repo;

import java.util.Date;

import com.example.weather.integration.ows.WeatherForecast;

public class ForecastCache {
	private String country;
	private String city;
	private WeatherForecast result;
	private Date cacheTimestamp;

	public ForecastCache(String country, String city, WeatherForecast result) {
		this.country = country;
		this.city = city;
		this.result = result;
		this.cacheTimestamp = new Date();
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public Date getCacheTimestamp() {
		return cacheTimestamp;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public WeatherForecast getResult() {
		return result;
	}


	public void setResult(WeatherForecast result) {
		this.result = result;
	}
	
	
	
}
