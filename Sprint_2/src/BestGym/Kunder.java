package BestGym;

import java.time.LocalDate;


public class Kunder {
    private String namn;
    private long personnummer;
    private LocalDate datumMedlem;
    private DatumHanterare datumHanterare;

    public String getNamn() {
        return namn;
    }

    public long getPersonnummer() {
        return personnummer;
    }

    public LocalDate getDatumMedlem() {
        return datumMedlem;
    }
    public DatumHanterare getDatumHanterare() {
        return datumHanterare;
    }

    public Kunder(String namn, long personnummer, LocalDate datumMedlem, DatumHanterare datumHanterare) {
        this.namn = namn;
        this.personnummer = personnummer;
        this.datumMedlem = datumMedlem;
        this.datumHanterare = datumHanterare;

    }


public boolean aktivMedlem(){
        LocalDate dagensDatum = datumHanterare.dagJustNu();
        LocalDate ettÅr = dagensDatum.minusYears(1);

        return datumMedlem.isAfter(ettÅr) || datumMedlem.isEqual(ettÅr);
}
public boolean inaktivMedlem(){
        LocalDate dagensDatum = datumHanterare.dagJustNu();
        LocalDate ettÅr = dagensDatum.minusYears(1);

        return datumMedlem.isBefore(ettÅr);
}
    @Override
    public String toString() {
        return "Namn: " + namn + ", Personnummer: " + personnummer + ", Medlem sedan: " + datumMedlem;
    }


}

