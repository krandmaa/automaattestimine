package mock.tests;

import fileIO.ReportWriter;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class testFileWriting {
    ReportWriter writer;

    @Test
    public void testWriteWeatherReport() throws IOException {
        writer = mock(ReportWriter.class);
    }
}
