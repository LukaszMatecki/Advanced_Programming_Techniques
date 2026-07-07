package SPOJ7;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj7 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int liczba_czasteczek = scanner.nextInt();
        String stan_czasteczki = scanner.next();

        int mutacje = 0;
        boolean czy_odwrocony_prefix = false;

        for (int i = 0; i < liczba_czasteczek; i++)
        {
            char c = stan_czasteczki.charAt(i);
            char rzeczywisty_stan_czasteczki = czy_odwrocony_prefix ? (c == 'A' ? 'B' : 'A') : c;

            if (rzeczywisty_stan_czasteczki == 'B')
            {
                mutacje++;
                czy_odwrocony_prefix = !czy_odwrocony_prefix;
            }
        }
        System.out.println("Minimalna liczba mutacji potrzebnych do zmiany całego DNA w same A: " + mutacje);
    }
}
