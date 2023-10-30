package org.example;

import java.util.Scanner;

public class Vragen {

    public void intro() {

        System.out.println("--------------------------------------------");
        System.out.println("Welkom bij HYPO de hypotheek berekenaar.");
        System.out.println("Kies uit een van de volgende opties:");
        System.out.println("--------------------------------------------");

    }

    public void options() {
        System.out.println("1 - Hypotheek, 2 - Exit");
    }

    public void formulier(Scanner input, Berekenaar hypo) {

        // postcode

        boolean gevalideerd = true;
        String postalCode = "";

        while (postalCode.length() < 4) {

            System.out.println("In welke postcode woon je?:");
            postalCode = input.next();

            if (postalCode.length() >= 4) {
                if (postalCode.equals("9679") || postalCode.equals("9681") || postalCode.equals("9682")) {
                    hypo.setPostcode(true);
                    System.out.println("dit is een verboden postcode!");
                    System.out.println("met dit postcode: " + postalCode + " mag je geen leening aanvragen.");

                    gevalideerd = false;
                    break;

                } else {
                    hypo.setPostcode(false);
                    System.out.println("dit is een correcte postcode!");
                }
            } else {
                System.out.println("Ongeldige postcode: de postcode moet minimaal 4 tekens bevatten.");
            }
        }

        if (gevalideerd) {

            // partner

            System.out.println("heb je een partner? 1 - ja, 2 - nee");
            int a = input.nextInt();
            switch (a) {
                case 1:
                    hypo.setPartner(true);
                    break;
                case 2:
                    hypo.setPartner(false);
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }

            // study

            System.out.println("heb je een studie schuld? 1 - ja, 2 - nee");
            int b = input.nextInt();
            switch (b) {
                case 1:
                    hypo.setStudieSchuld(true);
                    break;
                case 2:
                    hypo.setStudieSchuld(false);
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }

            // eigen income

            System.out.println("wat is je maandelijks inkomen?:");
            double c = input.nextDouble();

            hypo.setEigenInkomen(c);

            // partner income

            if(hypo.getPartner()) {
                System.out.println("wat is je partners maandelijks inkomen?:");
                double d = input.nextDouble();

                hypo.setPartnerInkomen(d);
            }
            else {
               System.out.println("je hebt geen partner.");
            }

            // term

            System.out.println("voor welk termijn wilt u lenen? hier komt automatisch Rente bij:");
            System.out.println("1 - 1 Jaar 2% Rente, 2 - 5 Jaar 3% Rente, 3 - 10 Jaar 3.5% Rente, 4 - 20 Jaar 4.5% Rente, 5 - 30 Jaar 5% Rente");

            int e = input.nextInt();
            switch (e) {
                case 1:
                    hypo.setTermijn(1);
                    hypo.setRente(0.02);
                    break;
                case 2:
                    hypo.setTermijn(5);
                    hypo.setRente(0.03);
                    break;
                case 3:
                    hypo.setTermijn(10);
                    hypo.setRente(0.035);
                    break;
                case 4:
                    hypo.setTermijn(20);
                    hypo.setRente(0.045);
                    break;
                case 5:
                    hypo.setTermijn(30);
                    hypo.setRente(0.05);
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }
}
