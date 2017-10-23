import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class maximumTempIsMaximumTest {
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
}
