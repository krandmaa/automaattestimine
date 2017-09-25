import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class getTemperatureByCoordsTest {
    @Test
    public void getCurrentCoordinatesTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            dayAverageTempCelsius = api.getCurrentCoordsTemp("35", "139");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }
}
