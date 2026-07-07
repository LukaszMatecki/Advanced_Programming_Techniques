package SPOJ7;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj7_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dlugoscDNA = scanner.nextInt();
        String dnaStart = scanner.next();
        char oczekiwanyZnak = 'A';
        int liczbaMutacji = 0;

        for (int i = dlugoscDNA - 1; i > 0; --i) {

            if (dnaStart.charAt(i) != oczekiwanyZnak) {

                if (dnaStart.charAt(i - 1) != oczekiwanyZnak)
                {
                    oczekiwanyZnak = dnaStart.charAt(i);
                    --i;
                }
                liczbaMutacji++;
            }
        }
        if (dnaStart.charAt(0) != oczekiwanyZnak) {liczbaMutacji++;}
        System.out.println(liczbaMutacji);
        scanner.close();
    }
}