import org.junit.Test;
import weatherApi.WeatherApi;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class minimumBelowMaximumTest {
    @Test
    public void testDailyMaximumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            double maxTemp = api.getDayMaxTemp(LocalDate.now());
            double minTemp = api.getDayMinTemp(LocalDate.now());
            assertTrue(maxTemp >= minTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
