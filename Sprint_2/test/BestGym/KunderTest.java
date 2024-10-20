package BestGym;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KunderTest {

    @Test
    public void testAktivMedlem() {
        List<Kunder> kunderlista = new ArrayList<>();
        Kunder aktivMedlem = new Kunder("Alhambra Aromes", 7703021234L, LocalDate.now().minusMonths(6),
                new DatumHanterare());

        kunderlista.add(aktivMedlem);

        assertTrue(aktivMedlem.aktivMedlem(), "Alhambra Aromes ska vara aktiv.");
        assertFalse(aktivMedlem.inaktivMedlem(), "Alhambra Aromes ska inte vara inaktiv.");
    }

    @Test
    public void testInaktivMedlem() {
        Kunder inaktivMedlem = new Kunder("Bear Belle", 8204021234L, LocalDate.now().minusYears(2),
                new DatumHanterare());

        assertTrue(inaktivMedlem.inaktivMedlem(), "Bear Belle ska vara inaktiv.");
        assertFalse(inaktivMedlem.aktivMedlem(), "Bear Belle ska inte vara aktiv.");
    }

    @Test
    public void testObehörigKund() {

        List<Kunder> kunderlista = new ArrayList<>();
        Kunder registreradKund = new Kunder("Alhambra Aromes", 7703021234L, LocalDate.now().minusMonths(6),
                new DatumHanterare());
        kunderlista.add(registreradKund);


        boolean hittad = false;
        long obehörigPersonnummer = 1234567890L;

        for (Kunder kund : kunderlista) {
            if (kund.getPersonnummer() == obehörigPersonnummer) {
                hittad = true;
                break;
            }
        }
        assertFalse(hittad, "Kunden borde vara obehörig.");
    }
}