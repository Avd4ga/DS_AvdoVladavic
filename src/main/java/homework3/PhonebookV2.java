package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        // main application logic
        System.out.println("Welcome to PhoneBookV2");

        Scanner scanner = new Scanner(System.in);
        RedBlackTree tree = null;
        try {
            tree = FileUtils.readFile("raw_phonebook_data.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No file: " + e.getMessage());
            scanner.close();
            return;
        }
        System.out.println("\nEntries loaded\n");
        System.out.println(GREEN+"System ready!"+RESET);

        System.out.println("\n=============================================================\n");


        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println(RED+"Number of red edges: "+RESET + edgeCounts[1]+"\n");
        System.out.println("Number of black edges: " + edgeCounts[0] + "\n");

        while (true) {
            System.out.print("Enter the name you want to to search (-1 to exit): ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Exiting Phonebook...");
                break;
            }

            ArrayList<Entry> entries = tree.get(input);
            if(entries != null) {
                System.out.println("Entries found: " + entries.size() + "\n");
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entries with the name in phonebook. \n");
            }
        }

        scanner.close();
    }
}
