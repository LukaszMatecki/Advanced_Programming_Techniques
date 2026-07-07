package SPOJ3;

import java.util.*;
import java.math.BigInteger;

public class Spoj3 {

    public static BigInteger factorial(int n)
    {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
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

