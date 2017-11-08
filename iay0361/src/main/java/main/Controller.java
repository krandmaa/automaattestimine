package main;

import fileIO.ReportWriter;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.io.IOException;


public class Controller {

    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        Location.readLocationFromFile();
        WeatherReport oneDayReport = weatherApi.createOneDayWeatherReport
                (Location.getCityName(), Location.getCountryCode(), Location.getFormat());
        WeatherReport threeDayReport = weatherApi.createThreeDayWeatherReport
                (Location.getCityName(), Location.getCountryCode(), Location.getFormat());
        System.out.println("Current temperature: " + oneDayReport.getCurrentTemp());
        System.out.println("Current day temperatures: " + oneDayReport.getCurrentDayTemperatures());
        System.out.println("Three day temperatures: " + threeDayReport.getThreeDayTemperatures());

        System.out.println(threeDayReport.getThreeDayForecast());

        ReportWriter writer = new ReportWriter();
        try {
            writer.writeWeatherReportToFile(threeDayReport);
            System.out.println("Report successfully writen.");
        } catch (IOException e) {
            System.out.println("Failed to write report.");
        }
    }
}
