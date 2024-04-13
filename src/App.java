import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> count = new HashMap<>();
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter filepath of the text file you want to examine");
        String filepath = scnr.nextLine();
        scnr.close();

        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(filepath)))
        {
            String word;
            while((word = reader.readLine()) != null)
            {
                String fix = word.toLowerCase();
                count.put(fix, count.getOrDefault(fix, 0) + 1);
            }
        }

        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new java.io.FileWriter("output.txt"))))
        {
            for(Map.Entry<String, Integer> entry:count.entrySet())
            {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        for(Map.Entry<String, Integer> entry:count.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
