package weatherapi;

import fileIO.UrlFileReader;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherReport {
    // Data:
    private double currentTemp = -273;
    private ArrayList<Double> allTemperatures = new ArrayList<>();

    private JSONObject jsonFile;
    public WeatherReport(double latitude, double longitude) {
    }

    public static WeatherReport createOneDayReport(String city, String country, String format) {
        return new WeatherReport(city, country, format, 1);
    }

    public static WeatherReport createThreeDayReport(String city, String country, String format) {
        return new WeatherReport(city, country, format, 3);
    }

    private WeatherReport(String city, String country, String format, int days){
        String location = city.toUpperCase() + "," + country.toUpperCase();
        String units = format.toLowerCase();
        String apiId = "42b13007be0d337745591f429f617215";
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?q="
                + location + "&units=" + units + "&APPID=" + apiId;

        UrlFileReader urlFileReader = new UrlFileReader();
        try {
            String urlReadContent = urlFileReader.readFromUrl(apiUrl);
            jsonFile = new JSONObject(urlReadContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDataFromFileAndSetPrivateValues(jsonFile, days);
    }

    private void getDataFromFileAndSetPrivateValues(JSONObject jsonFile, int days) {
        this.currentTemp = jsonFile.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");

        // Write all temperatures.
        for (int measureTimes = 0; measureTimes < days * 8 - 1; measureTimes++) {
            allTemperatures.add(
                    jsonFile.getJSONArray("list").getJSONObject(measureTimes).getJSONObject("main").getDouble("temp"));
        }
    }

    public double getDayTemp() {
        return -273;
    }

    public double convertToFahrenheit() {
        return -300;
    }

    public double getDayWindDegree() {
        //TODO: implement correct wind degree.
        return -1;
    }

    public double getCurrentPressure() {
        return -1;
    }

    public double getCurrentHumidity() {
        return -1;
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

    public double getNightTemp() {
        return -272;
    }

    public ArrayList<Double> getThreeDayTemperatures() {
        ArrayList<Double> threeDayTemperatures = new ArrayList<>();
        for (int days = 1; days <= 3; days++) {
            ArrayList<Double> oneDayTemperatures = new ArrayList<>();
            int currentDayMeasurements = 8;
            for (int currentMeasure = 0; currentMeasure < currentDayMeasurements; currentMeasure++) {
                oneDayTemperatures.add(allTemperatures.get(days * currentMeasure));
            }

            ArrayList<Double> currentDayTemperatures = new ArrayList<>();
            currentDayTemperatures.add(getDayMinTemp(oneDayTemperatures));
            currentDayTemperatures.add(getDayMaxTemp(oneDayTemperatures));

            threeDayTemperatures.addAll(currentDayTemperatures);
        }
        return threeDayTemperatures;
    }

    public ArrayList<Double> getDayRainMM() {
        ArrayList<Double> dayRainMM = new ArrayList<Double>();
        dayRainMM.add(-10.0);
        dayRainMM.add(40.0);
        return dayRainMM;
    }

    public double getDayWindSpeed() {
        return -1;
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

    public String getThreeDayForecast() {
        return getFirstDayForecast() + getSecondDayForecast() + getThirdDayForecast();
    }
}
