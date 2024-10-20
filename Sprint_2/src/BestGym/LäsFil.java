package BestGym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LäsFil {
    public List<Kunder> läsDataKund(String filnamn) {
        List<Kunder> kunderLista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filnamn))) {
            String rad;

            while ((rad = br.readLine()) != null) {
                String[] delar = rad.split(", ");
                long personnummer = Long.parseLong(delar[0]);
                String namn = delar[1];

                String datumRad = br.readLine();
                LocalDate datumMedlem = LocalDate.parse(datumRad);


                Kunder kund = new Kunder(namn, personnummer, datumMedlem, new DatumHanterare());
                kunderLista.add(kund);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kunderLista;
    }
}