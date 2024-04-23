import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter full name:");
        Scanner sc =  new Scanner(System.in);
        String fullName = sc.nextLine();
        System.out.println("Full name: " + fullName);
        try{
            FileWriter fw = new FileWriter( "./names.txt");
            fw.write(fullName);
            fw.close();
            File f = new File("./names.txt");
            FileReader fr = new FileReader(f);
            System.out.print("data: ");
            int data = fr.read();
            while (data != -1){
                System.out.print((char) data);
                data = fr.read();
            }
            fr.close();
        }catch (Exception e){
            System.out.println("An error occurred");
        }
    }
}
