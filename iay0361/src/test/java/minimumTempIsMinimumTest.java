import org.junit.Test;
import weatherApi.WeatherApi;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class minimumTempIsMinimumTest {
    @Test
    public void testDailyMinimumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Integer> oneDayTemperatures = api.getDayTemperatures(LocalDate.now());
            double minTemp = api.getDayMinTemp(LocalDate.now());

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
