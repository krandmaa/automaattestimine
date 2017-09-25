import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class lowestPressureTest {
    @Test
    public void testPressureNotTooLow(){
        try {
            WeatherApi api = new WeatherApi();
            double currentPressure = api.getCurrentCoordsPressure("35", "139");
            assertTrue(currentPressure >= 900);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
