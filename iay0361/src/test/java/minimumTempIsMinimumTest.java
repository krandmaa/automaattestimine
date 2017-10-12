import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class minimumTempIsMinimumTest {
    @Test
    public void testDailyMinimumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
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
}
