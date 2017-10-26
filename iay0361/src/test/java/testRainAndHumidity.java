import org.junit.Test;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testRainAndHumidity {

    @Test
    public void TestRainNotTooHighMM() {
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double hourRainMM = report.getDayRainMM().get(1);
            assertTrue(hourRainMM <= 20 && 0 <= hourRainMM);
        } catch (Exception e) {
            fail("Found too high or negative rain in millimetres for one hour.");
        }
    }

    @Test
    public void testHumidityBelowHundred(){
        try {
            WeatherApi api = new WeatherApi();
            WeatherReport report = api.createOneDayWeatherReport("Tallinn", "EE", "metric");
            double currentHumidity = report.getCurrentHumidity();
            assertTrue(currentHumidity <= 100 && currentHumidity >= 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}