import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj8_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < liczbaTestow; i++) {
            String ciag_znakow = scanner.nextLine().trim();
            System.out.println(odwroconaNotacjaPolskaRekurencyjnie(ciag_znakow, 0).wynik);
        }
        scanner.close();
    }

    private static class Wynik {
        String wynik;
        int indeks;

        Wynik(String wynik, int indeks) {this.wynik = wynik;this.indeks = indeks;}
    }

    private static Wynik odwroconaNotacjaPolskaRekurencyjnie(String ciag_znakow, int i)
    {
        StringBuilder wynik = new StringBuilder();
        char operator = 0;

        while (i < ciag_znakow.length()) {
            char znak = ciag_znakow.charAt(i);

            if (Character.isLetter(znak)) { wynik.append(znak); }
            else if (znak == '(') {
                Wynik wynikNawiasu = odwroconaNotacjaPolskaRekurencyjnie(ciag_znakow, i + 1);
                wynik.append(wynikNawiasu.wynik);
                i = wynikNawiasu.indeks;
            }
            else if (znak == ')') {
                if (operator != 0) wynik.append(operator);
                return new Wynik(wynik.toString(), i);
            }
            else { operator = znak;}
            i++;
        }
        return new Wynik(wynik.toString(), i);
    }
}