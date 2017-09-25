import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class humidityBelowHundredTest {
    @Test
    public void testHumidityBelowHundred(){
        try {
            WeatherApi api = new WeatherApi();
            double currentHumidity = api.getCurrentCoordsHumidity("35", "139");
            assertTrue(currentHumidity <= 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
