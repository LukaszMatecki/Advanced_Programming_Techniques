package SPOJ11;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj11 {
    public static void main(String[] args) {
        int liczba_testow, n, m, i, j, s, flag;
        Scanner scanner = new Scanner(System.in);
        liczba_testow = scanner.nextInt();

        while (liczba_testow > 0)
        {
            n = scanner.nextInt();
            m = scanner.nextInt();

            for (i = n; i <= m; i++)
            {
                flag = 0;
                if (i == 1) flag = 1;

                s = (int) Math.sqrt(i);
                for (j = 2; j <= s; j++)
                {
                    if (i % j == 0)
                    {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) System.out.println(i);
            }
            System.out.println();
            liczba_testow--;
        }
        scanner.close();
    }
}