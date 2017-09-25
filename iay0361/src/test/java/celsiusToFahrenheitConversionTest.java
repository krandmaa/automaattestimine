import org.junit.Test;
import weatherApi.WeatherApi;

import static org.junit.Assert.assertEquals;

public class celsiusToFahrenheitConversionTest {
    @Test
    public void testFahrenheitToCelsiusConversion() {
        WeatherApi api = new WeatherApi();
        double dayAverageTempCelsius = api.getDayAverageTempCelsius();
        double dayAverageTempFahrenheit = api.getDayAverageTempFahrenheit();
        assertEquals(dayAverageTempCelsius, (dayAverageTempFahrenheit - 32) / 1.8, 0.5);
    }
}
