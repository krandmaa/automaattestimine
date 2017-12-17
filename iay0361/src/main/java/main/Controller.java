package main;

import fileIO.LocationFileReader;
import fileIO.ReportWriter;
import weatherapi.ConsoleInput;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.io.IOException;


public class Controller {

    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        LocationFileReader reader = new LocationFileReader();
        ReportWriter writer = new ReportWriter();
        reader.readLocationFromFile();
        makeReports(weatherApi, reader, writer);
    }

    public static void makeReports(WeatherApi weatherApi, LocationFileReader reader, ReportWriter writer) {
        if (reader.getAllLocations().size() == 0) {
            System.out.println("Nothing found is Input.txt, use console:\n");
            Location location = new Location();
            new ConsoleInput(location);
            WeatherReport report = weatherApi.createThreeDayWeatherReport(location);
            try {
                writer.writeWeatherReportToFile(report, location);
                System.out.println("Report successfully written for " + location.getCityName() + ".");
            } catch (IOException e) {
                System.out.println("Unable to write report: " + e.getMessage());
            }
        } else {
            for (Location listLocation : reader.getAllLocations()) {
                try {
                    WeatherReport report = weatherApi.createThreeDayWeatherReport(listLocation);
                    writer.writeWeatherReportToFile(report, listLocation);
                    System.out.println("Report successfully written for " + listLocation.getCityName() + ".");
                } catch (IOException e) {
                    System.out.println("Unable to write report: " + e.getMessage());
                }
            }
        }
    }
}
