import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testPressure {

    @Test
    public void testPressureNotTooLow(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure >= 900);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void highestPressureNotTooHigh(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double currentPressure = report.getCurrentPressure();
            assertTrue(currentPressure <= 1100 && currentPressure > 0);
        } catch (Exception e) {
            fail("Found impossible air pressure.");
            e.printStackTrace();
        }
    }
}