package SPOJ2;

import java.util.*;

public class Spoj2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] S = new int[n];
        for (int i = 0; i < n; i++) {
            S[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] Q = new int[m];
        for (int i = 0; i < m; i++) {
            Q[i] = scanner.nextInt();
        }

        boolean first = true;
        for (int s : S) {
            int index = Arrays.binarySearch(Q, s);
            if (index < 0)
            {
                if (!first) System.out.print(" ");
                System.out.print(s);
                first = false;
            }
        }
        System.out.println();
    }
}
