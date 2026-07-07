import java.util.*;

public class Spoj10 {

    static final int SIZE = 101;
    static String[] table = new String[SIZE];

    static int hash(String key) {
        long h = 0;

        for (int i = 0; i < key.length(); i++) {
            h += (int) key.charAt(i) * (i + 1);
        }

        h *= 19;

        return (int) (h % SIZE);
    }

    static int find(String key) {
        int start = hash(key);

        for (int j = 0; j < 20; j++) {
            int index;

            if (j == 0) {
                index = start;
            } else {
                index = (start + j * j + 23 * j) % SIZE;
            }

            if (table[index] != null && table[index].equals(key)) {
                return index;
            }
        }

        return -1;
    }

    static void insert(String key) {
        if (find(key) != -1) {
            return;
        }

        int start = hash(key);

        for (int j = 0; j < 20; j++) {
            int index;

            if (j == 0) {
                index = start;
            } else {
                index = (start + j * j + 23 * j) % SIZE;
            }

            if (table[index] == null) {
                table[index] = key;
                return;
            }
        }
    }

    static void delete(String key) {
        int index = find(key);

        if (index != -1) {
            table[index] = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            table = new String[SIZE];

            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                String operation = scanner.nextLine();

                String key = operation.substring(4);

                if (operation.startsWith("ADD:")) {
                    insert(key);
                } else if (operation.startsWith("DEL:")) {
                    delete(key);
                }
            }

            int count = 0;

            for (String s : table) {
                if (s != null) {
                    count++;
                }
            }

            System.out.println(count);

            for (int i = 0; i < SIZE; i++) {
                if (table[i] != null) {
                    System.out.println(i + ":" + table[i]);
                }
            }
        }
        scanner.close();
    }
}