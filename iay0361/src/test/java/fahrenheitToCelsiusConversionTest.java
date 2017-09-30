import org.junit.Test;
import weatherApi.WeatherApi;
import weatherApi.WeatherReport;

import static org.junit.Assert.assertEquals;

public class fahrenheitToCelsiusConversionTest {
    @Test
    public void testCelsiusToFahrenheitConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport report = api.createWeatherReport("Tallinn" , "EE", "imperial");
        double dayAverageTempFahrenheit = report.getDayTemp();
        double dayAverageTempCelsius = report.convertToFahrenheit();
        assertEquals(dayAverageTempCelsius * 1.8 + 32, dayAverageTempFahrenheit, 0.5);
    }
}
