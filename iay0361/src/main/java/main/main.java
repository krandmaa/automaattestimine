package main;

import weatherapi.WeatherApi;
import weatherapi.WeatherReport;


public class main {
    private static String cityName = "Tallinn";
    private static String countryCode = "EE";
    private static String format = "metric";
    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        WeatherReport report = weatherApi.createWeatherReport(cityName, countryCode, format);
        System.out.println("Current temperature: " + report.getCurrentTemp());
        System.out.println("Current day temperatures: " + report.getCurrentDayTemperatures());
        System.out.println("Three day temperatures: " + report.getThreeDayTemperatures());

        System.out.println("Current day minimum: " + report.getThreeDayTemperatures().get(0));
        System.out.println("Current day maximum: " + report.getThreeDayTemperatures().get(1));
        System.out.println("Second day minimum: " + report.getThreeDayTemperatures().get(2));
        System.out.println("Second day maximum: " + report.getThreeDayTemperatures().get(3));
        System.out.println("Third day minimum: " + report.getThreeDayTemperatures().get(4));
        System.out.println("Third day maximum: " + report.getThreeDayTemperatures().get(5));

    }
}
