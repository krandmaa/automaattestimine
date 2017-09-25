import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertEquals;

public class fahrenheitToCelsiusConversionTest {
    @Test
    public void testCelsiusToFahrenheitConversion() {
        WeatherApi api = new WeatherApi();
        double dayAverageTempCelsius = api.getDayAverageTempCelsius();
        double dayAverageTempFahrenheit = api.getDayAverageTempFahrenheit();
        assertEquals(dayAverageTempCelsius * 1.8 + 32, dayAverageTempFahrenheit, 0.5);
    }
}
