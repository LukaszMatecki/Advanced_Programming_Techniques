package SPOJ12;

import java.io.*;
import java.util.*;

public class Spoj12 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        for (int test = 0; test < t; test++) {

            String line;

            do {
                line = br.readLine();
            } while (line != null && line.isEmpty());

            int n = Integer.parseInt(line.trim());

            HashMap<String, Integer> accounts = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String account = br.readLine();

                accounts.put(account, accounts.getOrDefault(account, 0) + 1);
            }

            ArrayList<String> sorted = new ArrayList<>(accounts.keySet());

            Collections.sort(sorted);

            for (String account : sorted) {
                output.append(account)
                        .append(accounts.get(account))
                        .append("\n");
            }

            if (test != t - 1) {
                output.append("\n");
            }
        }

        System.out.print(output);
    }
}