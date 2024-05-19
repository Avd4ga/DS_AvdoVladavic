package homework1;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        // implement the actual logic (remove next line)
        ArrayList<Entry> entries = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        ArrayList<String> lines = new ArrayList<>();
        while((line = reader.readLine()) != null){
            lines.add(line);
        }

        reader.close();

        for(String l : lines){
            String[] splitLine = l.split(";");

            if (splitLine[0].equals("name")){
                continue;
            }
            entries.add(new Entry(
                    splitLine[0],
                    splitLine[1],
                    splitLine[2],
                    splitLine[3],
                    splitLine[4],
                    splitLine[5]));
        }
        return entries.toArray(new Entry[0]);

    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for(Entry entry : entries){
            String line = entry.getName() + ";"
                    + entry.getAddress() + ";"
                    + entry.getCity() + ";"
                    + entry.getPostcode() + ";"
                    + entry.getCountry() + ";"
                    + entry.getPhoneNumber();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}