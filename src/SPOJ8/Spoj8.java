package SPOJ8;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Spoj8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int liczbaTestow = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < liczbaTestow; i++) {
            String ciag_znakow = scanner.nextLine().trim();
            Stack<Character> stos = new Stack<>();
            StringBuilder wynik = new StringBuilder();

            for(int j = 0; j < ciag_znakow.length(); j++)
            {
                char znak = ciag_znakow.charAt(j);

                if (Character.isLetter(znak)) { wynik.append(znak); }
                else if(!Character.isLetter(znak) && znak != '(' && znak != ')') { stos.push(znak); }
                else if (znak == ')') { wynik.append(stos.pop()); }
                else if (znak == '(') { continue; }
            }
            System.out.println(wynik.toString());
        }
        scanner.close();
    }
}