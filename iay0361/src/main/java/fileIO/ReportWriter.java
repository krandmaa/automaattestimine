package fileIO;

import weatherapi.Location;
import weatherapi.WeatherReport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter {
    //Initialize in case of bad input for file name.
    private String fileName = "Output.txt";

    public ReportWriter() {
    }

    public void writeWeatherReportToFile(WeatherReport report, Location location) throws IOException {
        verifyLocation(location);
        String threeDayForecast = report.getThreeDayForecast();
        String locationLine = getCurrentLocationData(location);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(locationLine);
        writer.newLine();
        writer.write(threeDayForecast);
        writer.flush();
        writer.close();
    }

    private void verifyLocation(Location location) {
        if (location.getCityName() != null && !location.getCityName().equals("")) {
            this.fileName = "./forecasts/" + location.getCityName() + ".txt";
        }
    }

    private String getCurrentLocationData(Location location) {
        return "Location: " + location.getCityName()
                + ", " + location.getCountryCode()
                + "; Data in: " + location.getFormat()
                + "\nCoordinates: " + location.getLatitude()
                + " : " + location.getLongitude();
    }
}
