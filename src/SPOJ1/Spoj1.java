package SPOJ1;

import java.util.Scanner;

public class Spoj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String liczba = scanner.nextLine();

            if (liczba.equals("42")) {
                break;
            }

            System.out.println(liczba);
        }
        scanner.close();
    }
}