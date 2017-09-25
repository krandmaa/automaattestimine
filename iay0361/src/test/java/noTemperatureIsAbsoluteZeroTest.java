import org.junit.Test;
import weatherApi.WeatherApi;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class noTemperatureIsAbsoluteZeroTest {
    @Test
    public void testTemperatureAboveAbsoluteZero() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Integer> threeDayTemperatures = api.getThreeDayTemperatures();
            int absoluteZero = -273;

            for (int temp : threeDayTemperatures) {
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
