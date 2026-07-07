import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < liczbaTestow; i++) {
            String wyrazenie = scanner.nextLine().trim();
            System.out.println(czyTautologia(wyrazenie) ? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean czyTautologia(String wyrazenie)
    {
        Set<Character> zmienne = new HashSet<>();
        for (char c : wyrazenie.toCharArray()) { if (Character.isLowerCase(c)) zmienne.add(c); }
        List<Character> lista = new ArrayList<>(zmienne); Collections.sort(lista);

        int n = lista.size();
        int kombinacje = 1 << n;

        for (int maska_bitowa = 0; maska_bitowa < kombinacje; maska_bitowa++)
        {
            Map<Character, Boolean> wartosci = new HashMap<>();
            for (int i = 0; i < n; i++) {
                wartosci.put(lista.get(i), (maska_bitowa & (1 << i)) != 0);
            }
            int[] pos = {0};
            if (!eval(wyrazenie, wartosci, pos)) return false;
        }
        return true;
    }

    private static boolean eval(String wyraz, Map<Character, Boolean> wartosci, int[] pos)
    {
        char znak = wyraz.charAt(pos[0]++);

        if (znak >= 'a' && znak <= 'z') { return wartosci.get(znak); }

        switch (znak)
        {
            case 'C':
            {
                boolean left = eval(wyraz, wartosci, pos);
                boolean right = eval(wyraz, wartosci, pos);
                return left && right;
            }
            case 'D':
            {
                boolean left = eval(wyraz, wartosci, pos);
                boolean right = eval(wyraz, wartosci, pos);
                return left || right;
            }
            case 'I':
            {
                boolean left = eval(wyraz, wartosci, pos);
                boolean right = eval(wyraz, wartosci, pos);
                return !left || right;
            }
            case 'E':
            {
                boolean left = eval(wyraz, wartosci, pos);
                boolean right = eval(wyraz, wartosci, pos);
                return left == right;
            }
            case 'N': return !eval(wyraz, wartosci, pos);
            default:  throw new IllegalArgumentException("Nieznany operator: " + znak);
        }
    }
}