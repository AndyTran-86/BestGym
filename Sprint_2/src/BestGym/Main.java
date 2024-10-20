package BestGym;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LäsFil läsFil = new LäsFil();
        List<Kunder> kunderLista = läsFil.läsDataKund("src/BestGym/dataKund.txt");

        Scanner sc = new Scanner(System.in);
        LoggaPT loggaPT = new LoggaPT("src/BestGym/PT_logg.txt");


        while (true) {
            System.out.println("Ange personnummer eller namn: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas.");
                break;
            }

            boolean hittad = false;

            if (input.length() == 10 && input.chars().allMatch(Character::isDigit)) {
                long inputPersonnummer = Long.parseLong(input);


                for (Kunder kund : kunderLista) {
                    if (kund.getPersonnummer() == inputPersonnummer) {
                        hittad = true;

                        if (kund.aktivMedlem()) {
                            System.out.println(kund.getNamn() + " är en aktiv medlem.");
                            loggaPT.loginBesök(kund);

                        } else if (kund.inaktivMedlem()) {
                            System.out.println(kund.getNamn() + " är en inaktiv medlem.\n");
                        }
                        break;
                    }
                }

            } else {

                for (Kunder kund : kunderLista) {
                    if (kund.getNamn().equalsIgnoreCase(input)) {
                        hittad = true;

                        if (kund.aktivMedlem()) {
                            System.out.println(kund.getNamn() + " är en aktiv medlem.");
                            loggaPT.loginBesök(kund);

                        } else if (kund.inaktivMedlem()) {
                            System.out.println(kund.getNamn() + " är en inaktiv medlem.\n");
                        }
                        break;
                    }
                }
            }
                    if (!hittad) {
                        System.out.println("Kunden är obehörig.\n");
                    }
                }
        sc.close();
    }
}





