package com.example.weather.web;

import java.util.ArrayList;
import java.util.List;

import com.example.weather.integration.ows.Weather;
import com.example.weather.integration.ows.WeatherEntry;
import com.example.weather.integration.ows.WeatherForecast;

class WeatherSummary {

	private final String country;

	private final String city;

	private final List<WeatherEntry> weathers;

	WeatherSummary(String country, String city, WeatherForecast weatherF) {
		this.country = country;
		this.city = city;
		this.weathers = weatherF.getEntries();
	}

	public String getCountry() {
		return this.country;
	}

	public String getCity() {
		return this.city;
	}

	public String getFahrenheitTemperature() {
		double fahrenheitTemp = (this.weathers.get(0).getTemperature() * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	
	public String getFahrenheitTemperatureDayTwo() {
		double fahrenheitTemp = (this.weathers.get(3).getTemperature() * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	
	public String getFahrenheitTemperatureDayThree() {
		double fahrenheitTemp = (this.weathers.get(6).getTemperature() * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	
	public String getFahrenheitTemperatureDayFour() {
		double fahrenheitTemp = (this.weathers.get(9).getTemperature() * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	
	public String getFahrenheitTemperatureDayFive() {
		double fahrenheitTemp = (this.weathers.get(12).getTemperature() * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	

	public String getCelsiusTemperature() {
		double celsiusTemp = this.weathers.get(0).getTemperature() - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	public String getCelsiusTemperatureDayTwo() {
		double celsiusTemp = this.weathers.get(3).getTemperature() - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	public String getCelsiusTemperatureDayThree() {
		double celsiusTemp = this.weathers.get(6).getTemperature() - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	public String getCelsiusTemperatureDayFour() {
		double celsiusTemp = this.weathers.get(9).getTemperature() - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	public String getCelsiusTemperatureDayFive() {
		double celsiusTemp = this.weathers.get(12).getTemperature() - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	

}
