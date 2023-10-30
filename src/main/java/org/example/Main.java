package org.example;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Berekenaar hypo = new Berekenaar();
        Vragen chat = new Vragen();

        boolean running = true;

        chat.intro();

        while (running) {

            try {

                chat.options();
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        hypo.reset();
                        System.out.println("De Hypo:");
                        chat.formulier(input, hypo);
                        calculate(input, chat, hypo);
                        break;
                    case 2:
                        System.out.println("Exit");
                        running = false;
                        break;
                    default:
                        System.out.println("Ongeldige keuze, probeer opnieuw.");

                }
            }
            catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("je hebt een verkeerde waarde ingevoerd!");
            }
            finally {
                System.out.println("TEST - Debug laatste code uitvoering!");
            }
        }
    }

    public static void calculate(Scanner input, Vragen chat, Berekenaar hypo) {

        DecimalFormat df = new DecimalFormat("#.00");

        double maximaleLeenStel = hypo.getMaxLeenBedrag() + (hypo.getMaxLeenBedrag() * 0.05);

        System.out.println("--------------------------------------------");
        System.out.println("Je maximale leen bedrag exclusief rente is: € "+df.format(hypo.getMaxLeenBedrag())+" Euro.");
        System.out.println("Met je gekozen termijn word dit: € "+df.format(hypo.getLeenBedragMetRente())+" Euro met een termijn van "+hypo.getTermijn()+" jaar en "+hypo.getRente()+"% rente die er op zit.");
        System.out.println("als je het maximale termijn van 30 jaar had gekozen dan was dit: € "+df.format(maximaleLeenStel)+" Euro met 0.05% rente geweest.");
        System.out.println("--------------------------------------------");

        // hoeveel wil je lenen

        System.out.println("Hoeveel wil je lenen, Maximaal € "+df.format(hypo.getMaxLeenBedrag())+" Euro: ");

        double kaas = 0;

        if (kaas <= maximaleLeenStel) {
            System.out.print("Enter a number: ");
            double userInput = input.nextDouble();
        }
        else {
            System.out.println("dit mag dus niet");
        }

        double aflossingPerMaand = hypo.getLeenBedragMetRente() / hypo.getTermijn() / 12;
        double alleenRente = aflossingPerMaand * hypo.getRente();

        System.out.println("Je moet dan € "+df.format(aflossingPerMaand)+" Euro per maand aflossen, dit is het totaal bedrag inclusief rente.");
        System.out.println("De rente die je maandelijks betaalt is: € "+df.format(alleenRente)+" Euro.");
        System.out.println("--------------------------------------------");
    }
}