import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class rainNotNegativeTest {
    @Test
    public void TestRainNotNegativeMM() {
        try {
            WeatherApi api = new WeatherApi();
            double hourRainMM = api.getOneDayRain().get(0);
            assertTrue(hourRainMM >= 0);
        } catch (Exception e) {
            fail("Found rain in negative millimetres.");
        }
    }
}
