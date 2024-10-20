package BestGym;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LäsFilTest {

    @Test
    void läsDataKund() {
        LäsFil läsfil = new LäsFil();

        List<Kunder> kunderLista = läsfil.läsDataKund("test/BestGym/testDataKund");

        assertNotNull(kunderLista, "Kundlistan ska inte vara null");
        assertFalse(kunderLista.isEmpty(), "Kundlistan ska inte vara tomt");

        Kunder förstaKund = kunderLista.get(0);
        assertEquals("Alhambra Aromes", förstaKund.getNamn(), "Första kundens ska vara 'Alhambra Aromes'");
        assertEquals(7703021234L, förstaKund.getPersonnummer(), "Första kundens personnummer ska vara '7703021234'");

        LocalDate expectedDate = LocalDate.of(2024, 7, 1);
        assertEquals(expectedDate, förstaKund.getDatumMedlem(), "Första kundens datum ska vara '2024-07-01'");
    }
}