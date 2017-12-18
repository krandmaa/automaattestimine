import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testWeatherReport {
    private Location location;

    @Before
    public void setUp() {
        this.location = new Location();
        this.location.setCityName("Tallinn");
        this.location.setCountryCode("EE");
        this.location.setFormat("metric");
    }

    @After
    public void tearDown() {
        this.location = null;
    }

    @Test
    public void getThreeDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
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
            WeatherReport report = api.createOneDayWeatherReport(location);
            ArrayList<Double> oneDayTemps = report.getCurrentDayTemperatures();

            assertTrue(oneDayTemps.size() <= 8);
        } catch (Exception e) {
            fail("Too many temperature results for one day.");
        }
    }

    @Test
    public void getCurrentCityTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport(location);
            dayAverageTempCelsius = report.getCurrentTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }

    @Test
    public void testReportExists() {
        WeatherApi api = new WeatherApi();
        WeatherReport report = api.createThreeDayWeatherReport(location);
        assertTrue(report.equals(api.getReport()));
    }

    @Test
    public void testGetThreeDayTemperatures() {
        WeatherApi api = new WeatherApi();
        WeatherReport report = api.createThreeDayWeatherReport(location);
        int size = report.getThreeDayTemperatures().size();
        assertTrue(size == 6);
    }
}
