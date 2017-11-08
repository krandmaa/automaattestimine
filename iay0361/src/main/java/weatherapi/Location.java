package weatherapi;

import fileIO.LocationFileReader;

import java.io.IOException;

//Store information about location and format.
public class Location {
    private static String cityName = "";
    private static String countryCode = "";
    private static String format = "metric";


    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        Location.cityName = cityName;
    }

    public static String getCountryCode() {
        return countryCode;
    }

    public static void setCountryCode(String countryCode) {
        Location.countryCode = countryCode;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        Location.format = format;
    }

    public static void readLocationFromFile() {
        LocationFileReader reader = new LocationFileReader();
        try {
            String[] fileLocationData = reader.readLocationFromFile();
            Location.setCityName(fileLocationData[0]);
            Location.setCountryCode(fileLocationData[1]);
            Location.setFormat(fileLocationData[2]);
        } catch (IOException e) {
            System.out.println("Failed to read from file, using defaults.");
            Location.setCityName("Tallinn");
            Location.setCountryCode("EE");
            Location.setFormat("metric");
        }
    }
}
