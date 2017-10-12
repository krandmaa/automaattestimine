package weatherapi;

import urlfilereader.UrlFileReader;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherReport {
    // Data:
    private double currentTemp = -273;
    private ArrayList<Double> allTemperatures = new ArrayList<>();

    private String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?q={Tallinn},{EE}&units=metric&APPID=42b13007be0d337745591f429f617215";

    private JSONObject jsonFile;
    public WeatherReport(double latitude, double longitude) {
    }

    public WeatherReport(String city, String country, String format){
        UrlFileReader urlFileReader = new UrlFileReader();
        try {
            String urlReadContent = urlFileReader.readFromUrl(apiUrl);
            jsonFile = new JSONObject(urlReadContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDataFromFileAndSetPrivateValues(jsonFile);
    }

    private void getDataFromFileAndSetPrivateValues(JSONObject jsonFile) {
        this.currentTemp = jsonFile.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");

        // Write all temperatures.
        for (int measureTimes = 0; measureTimes < 39; measureTimes++) {
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
        return -1;
    }

    public double getCurrentPressure() {
        return -1;
    }

    public double getCurrentHumidity() {
        return -1;
    }

    public ArrayList<Double> getCurrentDayTemperatures() {
        int currentDayMeasurements = 8;
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
}
