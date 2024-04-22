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
        }catch (Exception e){
            System.out.println("An error occurred");
        }
        
    }
}
