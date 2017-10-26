package main;

import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;


public class Main {

    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        WeatherReport oneDayReport = weatherApi.createOneDayWeatherReport
                (Location.getCityName(), Location.getCountryCode(), Location.getFormat());
        WeatherReport threeDayReport = weatherApi.createThreeDayWeatherReport
                (Location.getCityName(), Location.getCountryCode(), Location.getFormat());
        System.out.println("Current temperature: " + oneDayReport.getCurrentTemp());
        System.out.println("Current day temperatures: " + oneDayReport.getCurrentDayTemperatures());
        System.out.println("Three day temperatures: " + threeDayReport.getThreeDayTemperatures());

        System.out.println(threeDayReport.getThreeDayForecast());

    }
}
