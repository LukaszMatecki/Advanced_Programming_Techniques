import java.util.*;

public class Spoj2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] tablica1 = new int[n];
        for (int i = 0; i < n; i++) {
            tablica1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] tablica2 = new int[m];

        for (int i = 0; i < m; i++)
        {
            tablica2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (tablica1[i] == tablica2[j])
                {
                    System.out.print(tablica2[j] + " ");
                    found = true;
                    break;

                }
            }
            if (!found) {
                System.out.print(tablica1[i] + " ");
            }
        }
    }
}