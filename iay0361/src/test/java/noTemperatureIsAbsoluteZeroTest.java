import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class noTemperatureIsAbsoluteZeroTest {
    @Test
    public void testTemperatureAboveAbsoluteZero() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
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
}
