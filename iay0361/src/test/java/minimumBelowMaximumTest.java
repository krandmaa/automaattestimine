import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class minimumBelowMaximumTest {
    @Test
    public void testDailyMaximumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            ArrayList<Double> oneDayTemperatures = report.getCurrentDayTemperatures();
            double maxTemp = report.getDayMaxTemp(oneDayTemperatures);
            double minTemp = report.getDayMinTemp(oneDayTemperatures);
            assertTrue(maxTemp >= minTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
