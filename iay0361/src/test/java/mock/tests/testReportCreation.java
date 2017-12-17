package mock.tests;

import fileIO.LocationFileReader;
import fileIO.ReportWriter;
import main.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import weatherapi.Location;
import weatherapi.WeatherApi;
import weatherapi.WeatherReport;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class testReportCreation {

    WeatherApi api;
    WeatherReport report;
    Location location;

    @Before
    public void setUp() {
        api = mock(WeatherApi.class);
        this.location = new Location();
        this.location.setCityName("Tallinn");
        this.location.setCountryCode("EE");
        this.location.setFormat("metric");
    }

    @After
    public void tearDown() {
        this.api = null;
        this.location = null;
    }

    @Test
    public void testReportCreatedOnlyOnce() {
        when(api.createOneDayWeatherReport(any(Location.class))).thenReturn(mock(WeatherReport.class));
        report = api.createOneDayWeatherReport(this.location);
        when(api.getReport()).thenReturn(report);
        api.getReport().getCurrentDayTemperatures();
        api.getReport().getCurrentDayTemperatures();
        api.getReport().getCurrentTemp();
        verify(api, times(1)).createOneDayWeatherReport(location);
    }

    @Test
    public void testThreeDayReportCreatedOnlyOnce() throws IOException {
        when(api.createThreeDayWeatherReport(any(Location.class))).thenReturn(mock(WeatherReport.class));
        report = api.createThreeDayWeatherReport(this.location);
        when(api.getReport()).thenReturn(report);
        api.getReport().getThreeDayForecast();
        api.getReport().getSecondDayForecast();
        api.getReport().getCurrentTemp();
        verify(api, times(1)).createThreeDayWeatherReport(any(Location.class));
    }

    @Test
    public void testReportCreationViaConsole() {
        this.location.setFormat(null);
        this.location.setCountryCode(null);
        this.location.setCityName(null);
        report = api.createOneDayWeatherReport(location);
        when(api.getReport()).thenReturn(mock(WeatherReport.class));
        report = api.getReport();
        verify(api, times(1)).createOneDayWeatherReport(any(Location.class));
    }

    @Test
    public void testMakeAllReports() {
        ReportWriter writer = mock(ReportWriter.class);
        LocationFileReader reader = mock(LocationFileReader.class);
        when(reader.getAllLocations()).thenReturn(List.of(mock(Location.class)));
        Controller.makeReports(api, reader, writer);
    }
}
