package SPOJ4;

import java.util.*;
import java.lang.*;

public class Spoj4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();

        for (int i = 0; i < liczbaTestow; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int wynik1 = odwrocLiczbe(odwrocLiczbe(a) + odwrocLiczbe(b));
            int wynik2 = odwrocLiczbePetla(odwrocLiczbePetla(a) + odwrocLiczbePetla(b));
            int wynik3 = odwrocLiczbeRekurencyjnie(odwrocLiczbeRekurencyjnie(a) + odwrocLiczbeRekurencyjnie(b));

            System.out.println("1) Metoda używająca wbudowanych mechanizmów: " + wynik1);
            System.out.println("2) Metoda używająca pętli for: " + wynik2);
            System.out.println("3) Metoda używająca rekurencji: " + wynik3);
            System.out.println();
        }
    }

    public static int odwrocLiczbe(int liczba) {
        String odwrocony = new StringBuilder(Integer.toString(liczba)).reverse().toString();
        return Integer.parseInt(odwrocony);
    }

    public static int odwrocLiczbePetla(int liczba) {
        String liczbaStr = Integer.toString(liczba);
        String odwroconyStr = "";
        for (int i = liczbaStr.length() - 1; i >= 0; i--) {
            odwroconyStr += liczbaStr.charAt(i);
        }
        return Integer.parseInt(odwroconyStr);
    }

    public static int odwrocLiczbeRekurencyjnie(int liczba) {
        return odwrocRekurencyjnie(liczba, 0);
    }

    private static int odwrocRekurencyjnie(int liczba, int odwrocona) {
        if (liczba == 0) {
            return odwrocona;
        }
        return odwrocRekurencyjnie(liczba / 10, odwrocona * 10 + liczba % 10);
    }
}
