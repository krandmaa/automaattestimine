import org.junit.Test;
import weatherApi.WeatherApi;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class tooHighTemperatureTest {
    @Test
    public void testTemperatureNotTooHot() {
        try {
            WeatherApi api = new WeatherApi();
            ArrayList<Double> threeDayTemperatures = api.getThreeDayTemperatures();
            int abnormallyHotTemperature = 150;

            for (double temp : threeDayTemperatures) {
                if (temp >= abnormallyHotTemperature) {
                    fail("Higher than possible temperature found.");
                }
            }
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
