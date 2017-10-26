package main;

import weatherapi.WeatherApi;
import weatherapi.WeatherReport;


public class Main {
    private static String cityName = "pariis";
    private static String countryCode = "ee";
    private static String format = "metric";

    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        WeatherReport oneDayReport = weatherApi.createOneDayWeatherReport(cityName, countryCode, format);
        WeatherReport threeDayReport = weatherApi.createThreeDayWeatherReport(cityName, countryCode, format);
        System.out.println("Current temperature: " + oneDayReport.getCurrentTemp());
        System.out.println("Current day temperatures: " + oneDayReport.getCurrentDayTemperatures());
        System.out.println("Three day temperatures: " + threeDayReport.getThreeDayTemperatures());

        System.out.println(threeDayReport.getThreeDayForecast());

    }
}
