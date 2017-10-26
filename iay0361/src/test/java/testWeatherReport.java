import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testWeatherReport {

    @Test
    public void getThreeDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemps = report.getCurrentDayTemperatures();

            assertTrue(oneDayTemps.size() <= 24);
        } catch (Exception e) {
            fail("Too many temperature results for three days.");
        }
    }

    @Test
    public void getOneDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemps = report.getCurrentDayTemperatures();

            assertTrue(oneDayTemps.size() <= 8);
        } catch (Exception e) {
            fail("Too many temperature results for one day.");
        }
    }

    @Test
    public void getCurrentCoordinatesTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport(35, 139);
            dayAverageTempCelsius = report.getDayTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }

    @Test
    public void getCurrentCityTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            dayAverageTempCelsius = report.getCurrentTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }

    @Test
    public void TestForecastFileFormat() {
        try {
            WeatherApi api = new WeatherApi();
            String fileName = api.getForecastFileName();
            assertTrue(fileName.toLowerCase().endsWith("xml") || fileName.toLowerCase().endsWith("json"));
        } catch (Exception e) {
            fail("Could not get forecast file in proper format.");
        }
    }
}


