import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class windSpeedAboveZeroTest {
    @Test
    public void testWindSpeedAboveZero(){
        try {
            WeatherApi api = new WeatherApi();
            double currentWindSpeed = api.getCurrentCoordsWind("35", "139");
            assertTrue(currentWindSpeed >= 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
