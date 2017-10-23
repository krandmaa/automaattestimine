import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertEquals;

public class celsiusToFahrenheitConversionTest {
    @Test
    public void testFahrenheitToCelsiusConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport reportMetric = api.createOneDayWeatherReport("Tallinn" , "EE", "metric");
        WeatherReport reportFahrenheit = api.createOneDayWeatherReport("Tallinn" , "EE", "imperial");
        double dayAverageTempCelsius = reportMetric.getCurrentTemp();
        double dayAverageTempFahrenheit = reportFahrenheit.getCurrentTemp();
        assertEquals(dayAverageTempCelsius, (dayAverageTempFahrenheit - 32) / 1.8, 0.5);
    }
}
