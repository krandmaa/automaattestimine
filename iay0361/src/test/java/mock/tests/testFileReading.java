package mock.tests;

import fileIO.LocationFileReader;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class testFileReading {
    LocationFileReader reader;

    @Test
    public void testReadingData() throws IOException {
        reader = mock(LocationFileReader.class);
        reader.readLocationFromFile();
        verify(reader, times(1)).readLocationFromFile();
    }

    @Test
    public void testGettingDataBeforeReading() throws IOException {
        reader = mock(LocationFileReader.class);
        reader.getAllLocations();
        verify(reader, times(0)).readLocationFromFile();
    }
}
