package BestGym;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class LoggaPT {

    private String filnamn;

    public LoggaPT(String filnamn) {
        this.filnamn = filnamn;
    }


    public void loginBesök(Kunder kund){
        LocalDate dagensDatum = LocalDate.now();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filnamn, true))) {
            bw.write("Namn: " + kund.getNamn() + ", Personnummer: " + kund.getPersonnummer() + ", Datum: " + dagensDatum);
            bw.newLine();
            System.out.println(kund.getNamn() + " har loggat in.\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
