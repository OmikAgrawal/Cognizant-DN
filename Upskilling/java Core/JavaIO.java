import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class JavaIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        try(FileWriter fw = new FileWriter("output.txt");
            BufferedWriter writer = new BufferedWriter(fw);){

            writer.write(userInput);

            writer.close();

            System.out.println("Successfully write the data to Output.txt");
        }
        catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        }

        sc.close();


        try(FileReader fr = new FileReader("output.txt");
            BufferedReader reader = new BufferedReader(fr);){
        
            System.out.println("---Reading output.txt file---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            System.out.println("--------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("[ERROR] :" + e.getMessage());
        }

    }
}
