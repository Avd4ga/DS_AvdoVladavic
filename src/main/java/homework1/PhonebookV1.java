package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {


        Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");
        System.out.println("Entries Loaded...");
        MergeSort.sort(entries);
        System.out.println("Entries Sorted...");

        FileUtils.writeToFile(entries, "result.csv");
        System.out.println("System is ready for operation!");

        System.out.println("==========================================");
        Scanner input = new Scanner(System.in);

        while(true){

            System.out.println("Enter the searched name (Surname, Name), or enter -1 to exit the program: ");
            String name = input.nextLine();
            if(name.equals("-1")){
                break;
            }
            else{
                int[] indexes = BinarySearch.search(entries, name);
                if(indexes.length==0){
                    System.out.println("Entry does not exist!");
                }
                else{
                    for(int i : indexes){
                        System.out.println(entries[i]);
                    }
                }
            }
        }

    }
}