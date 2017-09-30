package weatherApi;

import java.util.ArrayList;

public class WeatherReport {
    public WeatherReport(double latitude, double longitude) {
    }

    public WeatherReport(String city, String country, String format) {
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
        ArrayList<Double> currentDayTemps = new ArrayList<Double>();
        currentDayTemps.add(-301.0);
        currentDayTemps.add(301.0);
        for (int i = 0; i < 30; i++) {
            currentDayTemps.add(0d);
        }
        return currentDayTemps;
    }

    public double getDayMaxTemp() {
        return -300;
    }

    public double getDayMinTemp() {
        return 300;
    }

    public double getCurrentTemp() {
        return -273;
    }

    public double getNightTemp() {
        return -272;
    }

    public ArrayList<Double> getThreeDayTemperatures() {
        ArrayList<Double> threeDayTemperatures = new ArrayList<Double>();
        threeDayTemperatures.add(-300.0);
        threeDayTemperatures.add(1000.0);
        for (int i = 0; i < 30; i++) {
            threeDayTemperatures.add(0d);
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
