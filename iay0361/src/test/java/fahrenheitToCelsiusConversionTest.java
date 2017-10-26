import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertEquals;

public class fahrenheitToCelsiusConversionTest {
    @Test
    public void testCelsiusToFahrenheitConversion() {
        WeatherApi api = new WeatherApi();
        WeatherReport reportFahrenheit = api.createOneDayWeatherReport("Tallinn" , "EE", "imperial");
        WeatherReport reportMetric = api.createOneDayWeatherReport("Tallinn" , "EE", "metric");
        double dayAverageTempCelsius = reportMetric.getCurrentTemp();
        double dayAverageTempFahrenheit = reportFahrenheit.getCurrentTemp();
        assertEquals(dayAverageTempCelsius * 1.8 + 32, dayAverageTempFahrenheit, 0.5);
    }
}
