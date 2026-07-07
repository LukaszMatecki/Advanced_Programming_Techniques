import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < liczbaTestow; i++) {
            String liczba = scanner.nextLine().trim();
            System.out.println("Następny, najmniejszy, ale większy od obecnego palindrom to: " + nastepnyPalindrom(liczba));
        }
        scanner.close();
    }

    private static String nastepnyPalindrom(String liczba)
    {
        int dlugosc_liczby = liczba.length();

        if (czySameDziewiatki(liczba)) {
            StringBuilder wynik = new StringBuilder("1");
            for (int i = 1; i < dlugosc_liczby; i++) wynik.append("0");
            wynik.append("1");
            return wynik.toString();
        }

        int[] cyfry = new int[dlugosc_liczby];
        for (int i = 0; i < dlugosc_liczby; i++) {cyfry[i] = liczba.charAt(i) - '0';}

        int srodek = dlugosc_liczby / 2;
        int lewy = srodek - 1;
        int prawy = (dlugosc_liczby % 2 == 0) ? srodek : srodek + 1;

        while (lewy >= 0) {
            cyfry[prawy++] = cyfry[lewy--];
        }

        if (nowyWiekszy(cyfry, liczba))
            return tablicaNaString(cyfry);

        int przeniesienie = 1;

        if (dlugosc_liczby % 2 == 1) {
            int cyfra = cyfry[srodek] + przeniesienie;
            przeniesienie = cyfra / 10;
            cyfry[srodek] = cyfra % 10;
            lewy = srodek - 1;
            prawy = srodek + 1;
        } else {
            lewy = srodek - 1;
            prawy = srodek;
        }

        while (lewy >= 0)
        {
            int cyfra = cyfry[lewy] + przeniesienie;
            przeniesienie = cyfra / 10;
            cyfry[lewy] = cyfra % 10;
            cyfry[prawy] = cyfry[lewy];
            lewy--;
            prawy++;
        }
        return tablicaNaString(cyfry);
    }

    private static boolean czySameDziewiatki(String liczba) {
        for (char c : liczba.toCharArray()) {
            if (c != '9') return false;
        }
        return true;
    }

    private static boolean nowyWiekszy(int[] nowy, String stary) {
        for (int i = 0; i < nowy.length; i++) {
            int staraCyfra = stary.charAt(i) - '0';
            if (nowy[i] > staraCyfra) return true;
            if (nowy[i] < staraCyfra) return false;
        }
        return false;
    }

    private static String tablicaNaString(int[] cyfry) {
        StringBuilder wynik = new StringBuilder();
        for (int c : cyfry) wynik.append(c);
        return wynik.toString();
    }
}
