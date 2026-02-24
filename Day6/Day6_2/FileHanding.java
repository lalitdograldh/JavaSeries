package Day6.Day6_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.Scanner;

public class FileHanding {
    public static void main(String[] args) {
        try {
            File mFile = new File("intro.txt");
            boolean fileCreated = mFile.createNewFile();
            if (fileCreated) {
                System.out.println("File created successfully " +mFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter(mFile,true);
            writer.write("Welcome to Java Programming! \n");
            writer.write("Hello World! \n");
            writer.close();
            // Scanner reader = new Scanner(mFile);
            // while (reader.hasNextLine()) {
            //     System.out.println(reader.nextLine());                
            // }
            // reader.close();
            BufferedReader reader = new BufferedReader(new FileReader(mFile));
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }
            reader.close();
            System.out.println(mFile.delete());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
