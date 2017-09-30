import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class minimumBelowMaximumTest {
    @Test
    public void testDailyMaximumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport("Tallinn", "EE", "metric");
            double maxTemp = report.getDayMaxTemp();
            double minTemp = report.getDayMinTemp();
            assertTrue(maxTemp >= minTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
