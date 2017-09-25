import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertTrue;

public class getTemperatureByCityTest {
    @Test
    public void getCurrentCityTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            dayAverageTempCelsius = api.getCurrentCityTemp("Tallinn");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }
}
