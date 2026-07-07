import java.util.*;
import java.lang.*;

public class Spoj5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();

        for (int i = 0; i < liczbaTestow; i++) {
            long numer_n = scanner.nextLong();
            long numer_n_iteracja = numer_n;
            long wynik = 0;

            while (numer_n_iteracja >= 5) {
                numer_n_iteracja = numer_n_iteracja / 5;
                wynik = wynik + numer_n_iteracja;
            }
            
            long wynikRekurencyjnie = zeraRekurencyjnie(numer_n);
            System.out.println("Twoj wynik iteracyjnie: " + wynik);
            System.out.println("Twoj wynik rekurencyjnie: " + wynikRekurencyjnie);
        }
    }

    public static long zeraRekurencyjnie(long n) {
        if (n < 5) return 0;
        return (n / 5) + zeraRekurencyjnie(n / 5);
    }
}

