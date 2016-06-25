package com.brd.business.weather.test;

import java.util.List;

import com.brd.business.weather.java.ArrayOfString;
import com.brd.business.weather.java.WeatherWS;
import com.brd.business.weather.java.WeatherWSSoap;

public class Test {

	public static void main(String[] args) {
		WeatherWS weatherWS = new WeatherWS();
		WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
		ArrayOfString weather = weatherWSSoap.getWeather("北京", null);
		List<String> list = weather.getString();
		for (String string:list) {

			System.out.println(string);
		}
	}

}
