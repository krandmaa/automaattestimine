import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testTemperatures {

    @Test
    public void testTemperatureNotTooHot() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> threeDayTemperatures = report.getThreeDayTemperatures();
            int abnormallyHotTemperature = 150;

            for (double temp : threeDayTemperatures) {
                if (temp >= abnormallyHotTemperature) {
                    fail("Higher than possible temperature found.");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemperaturesInKelvinAboveZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "standard");
            ArrayList<Double> threeDayTemperatures = report.getThreeDayTemperatures();
            for (double temp : threeDayTemperatures) {
                if (temp <= 0) {
                    fail("Impossible kelvin temperature");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemperatureAboveAbsoluteZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> threeDayTemperatures = report.getThreeDayTemperatures();
            int absoluteZero = -273;

            for (double temp : threeDayTemperatures) {
                if (temp <= absoluteZero) {
                    fail("Lower than absolute zero temperature found!");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDailyMinimumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemperatures = report.getCurrentDayTemperatures();
            double minTemp = report.getDayMinTemp(oneDayTemperatures);

            for (double temp : oneDayTemperatures) {
                if (temp < minTemp) {
                    fail("Found lower temperature.");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMinTempLowerThanMaxTemp() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemperatures = report.getCurrentDayTemperatures();
            double maxTemp = report.getDayMaxTemp(oneDayTemperatures);
            double minTemp = report.getDayMinTemp(oneDayTemperatures);
            assertTrue(maxTemp >= minTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDailyMaximumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemperatures = report.getCurrentDayTemperatures();
            double maxTemp = report.getDayMaxTemp(oneDayTemperatures);

            for (double temp : oneDayTemperatures) {
                if (temp > maxTemp) {
                    fail("Found higher temperature.");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCelsiusToFahrenheitConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport reportFahrenheit = api.createOneDayWeatherReport("Tallinn" , "EE", "imperial");
        WeatherReport reportMetric = api.createOneDayWeatherReport("Tallinn" , "EE", "metric");

        double dayAverageTempCelsius = reportMetric.getCurrentTemp();
        double dayAverageTempFahrenheit = reportFahrenheit.getCurrentTemp();

        assertEquals(dayAverageTempCelsius * 1.8 + 32, dayAverageTempFahrenheit, 0.5);
    }

    @Test
    public void testFahrenheitToCelsiusConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport reportMetric = api.createOneDayWeatherReport("Tallinn" , "EE", "metric");
        WeatherReport reportFahrenheit = api.createOneDayWeatherReport("Tallinn" , "EE", "imperial");

        double dayAverageTempCelsius = reportMetric.getCurrentTemp();
        double dayAverageTempFahrenheit = reportFahrenheit.getCurrentTemp();

        assertEquals(dayAverageTempCelsius, (dayAverageTempFahrenheit - 32) / 1.8, 0.5);
    }
}
