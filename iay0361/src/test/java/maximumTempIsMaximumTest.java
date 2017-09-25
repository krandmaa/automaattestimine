import org.junit.Test;
import weatherApi.WeatherApi;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class maximumTempIsMaximumTest {
    @Test
    public void testDailyMaximumTemperature() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Integer> oneDayTemperatures = api.getDayTemperatures(LocalDate.now());
            double maxTemp = api.getDayMaxTemp(LocalDate.now());

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
