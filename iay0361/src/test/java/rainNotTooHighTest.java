import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class rainNotTooHighTest {
    @Test
    public void TestRainNotTooHighMM() {
        try {
            WeatherApi api = new WeatherApi();
            double hourRainMM = api.getOneDayRain().get(0);
            assertTrue(hourRainMM <= 20);
        } catch (Exception e) {
            fail("Found too high rain in millimetres for one hour.");
        }
    }
}
