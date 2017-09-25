import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class highestPressureTest {
    @Test
    public void highestPressureNotTooHigh(){
        try {
            WeatherApi api = new WeatherApi();
            double currentPressure = api.getCurrentCoordsPressure("35", "139");
            assertTrue(currentPressure <= 1100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
