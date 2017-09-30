import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertEquals;

public class celsiusToFahrenheitConversionTest {
    @Test
    public void testFahrenheitToCelsiusConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport report = api.createWeatherReport("Tallinn" , "EE", "metric");
        double dayAverageTempCelsius = report.getDayTemp();
        double dayAverageTempFahrenheit = report.convertToFahrenheit();
        assertEquals(dayAverageTempCelsius, (dayAverageTempFahrenheit - 32) / 1.8, 0.5);
    }
}
