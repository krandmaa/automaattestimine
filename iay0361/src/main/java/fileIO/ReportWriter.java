package fileIO;

import weatherapi.Location;
import weatherapi.WeatherReport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    private String fileName = "Output.txt";

    public ReportWriter() {
    }

    public void writeWeatherReportToFile(WeatherReport report) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String locationLine = getCurrentLocation();
        String threeDayForecast = report.getThreeDayForecast();
        writer.write(locationLine);
        writer.newLine();
        writer.write(threeDayForecast);
        writer.flush();
        writer.close();
    }

    private String getCurrentLocation() {
        return "Location: " + Location.getCityName() + ", " + Location.getCountryCode() + "; Data in: " + Location.getFormat();
    }
}
