import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class oneDayTempForecastCountCorrectTest {
    @Test
    public void GetOneDayTemperaturesCountCorrect() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemps = report.getCurrentDayTemperatures();

            assertTrue(oneDayTemps.size() <= 8);
        } catch (Exception e) {
            fail("Too many temperature results for one day.");
        }
    }
}
