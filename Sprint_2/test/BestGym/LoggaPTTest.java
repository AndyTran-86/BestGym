package BestGym;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoggaPTTest {

    @Test
    void testLoginBesök() throws IOException {
        Path tempFile = Files.createTempFile("pt_logg", ".txt");

        LocalDate mockDatum = LocalDate.of(2025, 1, 1);

        DatumHanterare mockDatumHanterera = new DatumHanterare() {
            @Override
            public LocalDate dagJustNu() {
                return mockDatum;
            }
        };

        Kunder kund = new Kunder("Kadine Karlsson", 4604151234L, mockDatum.minusMonths(6), mockDatumHanterera);

        LoggaPT loggaPT = new LoggaPT(tempFile.toString().replace(".txt", ""));

        String filinnehåll = Files.readString(tempFile);

        assertTrue(filinnehåll.contains("Kadine Karlsson"), "Kunden finns i filen");
        assertTrue(filinnehåll.contains("4604151234"), "Kundens personnummer finns i filen");
        assertTrue(filinnehåll.contains(mockDatum.toString()), "Dagens mock datum finns i filen");

        Files.deleteIfExists(tempFile);
        }


}

