package SPOJ3;

import java.util.*;
import java.math.BigInteger;

public class Spoj3_2 {

    public static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] tablica = new int[n];
        for (int i = 0; i < n; i++) {
            tablica[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(factorial(tablica[i]));
        }
    }
}

