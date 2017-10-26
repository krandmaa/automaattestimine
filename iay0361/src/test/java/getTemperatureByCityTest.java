import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;

public class getTemperatureByCityTest {
    @Test
    public void getCurrentCityTemperature() {
        double dayAverageTempCelsius = -273;
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            dayAverageTempCelsius = report.getCurrentTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(dayAverageTempCelsius != -273);
    }
}
