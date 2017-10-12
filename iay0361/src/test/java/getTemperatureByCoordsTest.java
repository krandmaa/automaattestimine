import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class getTemperatureByCoordsTest {
    @Test
    public void getCurrentCoordinatesTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createWeatherReport(35, 139);
            dayAverageTempCelsius = report.getDayTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }
}
