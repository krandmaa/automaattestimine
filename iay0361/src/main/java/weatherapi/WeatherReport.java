package weatherapi;

import fileIO.UrlFileReader;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherReport {
    // Data:
    private double currentTemp = -273;
    private ArrayList<Double> allTemperatures = new ArrayList<>();

    private JSONObject jsonFile;
    public WeatherReport(double latitude, double longitude) {
    }

    public static WeatherReport createOneDayReport(Location location) {
        return new WeatherReport(location, 1);
    }

    public static WeatherReport createThreeDayReport(Location location) {
        return new WeatherReport(location, 3);
    }

    private WeatherReport(Location location, int days){
        if (!checkLocationFormat(location.getCityName(), location.getCountryCode())) {
            System.out.println("Invalid location format detected, using: EE, Tallinn.");
            location.setCityName("Tallinn");
            location.setCountryCode("EE");
        }
        String apiUrl = makeURL(location.getCityName(), location.getCountryCode(), location.getFormat());

        UrlFileReader urlFileReader = new UrlFileReader();
        try {
            String urlReadContent = urlFileReader.readFromUrl(apiUrl);
            jsonFile = new JSONObject(urlReadContent);
            getDataFromFileAndSetPrivateValues(jsonFile, days, location);
        } catch (FileNotFoundException f) {
            System.out.println("Could not read weather data from URL: \n" + apiUrl);
        } catch (Exception e) {
            System.out.println("Could not connect to the API, check network connection.");
        }
    }

    private static String makeURL(String city, String country, String format) {
        String location = city.toUpperCase() + "," + country.toUpperCase();
        if (country.equals("x")) {
            location = city.toUpperCase();
        }
        String units = format.toLowerCase();
        String apiId = "42b13007be0d337745591f429f617215";
        return "http://api.openweathermap.org/data/2.5/forecast?q="
                + location + "&units=" + units + "&APPID=" + apiId;
    }

    private static boolean checkLocationFormat(String city, String country) {
        return city != null && country != null && !city.equals("") && !country.equals("");
    }

    private void getDataFromFileAndSetPrivateValues(JSONObject jsonFile, int days, Location location) {
        this.currentTemp = jsonFile.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
        // Write location information:
        location.setLatitude("" + jsonFile.getJSONObject("city").getJSONObject("coord").getDouble("lat"));
        location.setLongitude("" + jsonFile.getJSONObject("city").getJSONObject("coord").getDouble("lon"));
        location.setCountryCode(jsonFile.getJSONObject("city").getString("country"));
        // Write all temperatures.
        for (int measureTimes = 0; measureTimes < days * 8; measureTimes++) {
            allTemperatures.add(
                    jsonFile.getJSONArray("list").getJSONObject(measureTimes).getJSONObject("main").getDouble("temp"));
        }
    }

    public double getDayWindDegree() {
        //TODO: implement correct wind degree.
        return 1;
    }

    public double getCurrentPressure() {
        return 1000;
    }

    public double getCurrentHumidity() {
        return 90;
    }

    public ArrayList<Double> getCurrentDayTemperatures() {
        int currentDayMeasurements = 7;
        ArrayList<Double> oneDayTemperatures = new ArrayList<>();

        // Get all 8 measures for one day.
        for (int currentMeasure = 0; currentMeasure < currentDayMeasurements; currentMeasure++) {
            oneDayTemperatures.add(allTemperatures.get(currentMeasure));
        }

        // Get min and max temps for that day and return it.
        ArrayList<Double> currentDayTemperatures = new ArrayList<>();
        currentDayTemperatures.add(getDayMinTemp(oneDayTemperatures));
        currentDayTemperatures.add(getDayMaxTemp(oneDayTemperatures));

        return currentDayTemperatures;
    }

    public double getDayMaxTemp(ArrayList<Double> dayTemps) {
        double maxTemp = -300;
        for (Double temperature: dayTemps) {
            if (temperature >= maxTemp) {
                maxTemp = temperature;
            }
        }

        return maxTemp;
    }

    public double getDayMinTemp(ArrayList<Double> dayTemps) {
        double minTemp = 300;
        for (Double temperature: dayTemps) {
            if (temperature <= minTemp) {
                minTemp = temperature;
            }
        }
        return minTemp;
    }

    public double getCurrentTemp() {
        return this.currentTemp;
    }

    public ArrayList<Double> getThreeDayTemperatures() {
        if (!checkDataAvailability()) {
            return getCurrentDayTemperatures();
        }
        ArrayList<Double> threeDayTemperatures = new ArrayList<>();
        for (int days = 0; days < 3; days++) {
            ArrayList<Double> oneDayTemperatures = new ArrayList<>();
            int currentDayMeasurements = 8;
            for (int currentMeasure = 0; currentMeasure < currentDayMeasurements; currentMeasure++) {
                oneDayTemperatures.add(allTemperatures.get(days * currentDayMeasurements + currentMeasure));
            }

            ArrayList<Double> currentDayTemperatures = new ArrayList<>();
            currentDayTemperatures.add(getDayMinTemp(oneDayTemperatures));
            currentDayTemperatures.add(getDayMaxTemp(oneDayTemperatures));

            threeDayTemperatures.addAll(currentDayTemperatures);
        }
        return threeDayTemperatures;
    }

    private boolean checkDataAvailability() {
        return this.allTemperatures.size() > 8;
    }

    public ArrayList<Double> getDayRainMM() {
        //TODO: Implement rain.
        ArrayList<Double> dayRainMM = new ArrayList<>();
        dayRainMM.add(5.0);
        dayRainMM.add(1.0);
        return dayRainMM;
    }

    public double getDayWindSpeed() {
        //TODO: Implement wind speed.
        return 1;
    }

    public String getFirstDayForecast() {
        return "\nCurrent day minimum: " + this.getThreeDayTemperatures().get(0) + "\n" +
                "Current day maximum: " + this.getThreeDayTemperatures().get(1);
    }

    public String getSecondDayForecast() {
        return "\nSecond day minimum: " + this.getThreeDayTemperatures().get(2) + "\n" +
                "Second day maximum: " + this.getThreeDayTemperatures().get(3);
    }

    public String getThirdDayForecast() {
        return "\nThird day minimum: " + this.getThreeDayTemperatures().get(4) + "\n" +
                "Third day maximum: " + this.getThreeDayTemperatures().get(5);
    }

    public String getThreeDayForecast() throws IOException {
        if (allTemperatures.size() < 23) {
            throw new IOException("No data for city.");
        }
        return getFirstDayForecast() + getSecondDayForecast() + getThirdDayForecast() + "\n\nCurrent temperature: "
                + currentTemp;
    }
}
