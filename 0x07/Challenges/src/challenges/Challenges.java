package challenges;

import java.util.Random;
import java.util.Scanner;

public class Challenges {
    public static void main(String[] args) {
        //celsiusToFahrenheit();
        //guessTheNumber();
        bank();
    }
    
    // Programa que retorne el resultado de convertir grados Celsius a Fahrenheit.
    private static void celsiusToFahrenheit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter degrees Celsius:");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 1.8) + 32;        
        System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    }
    
    /* Programa que simule un juego de adivinanzas.
    El programa debe generar un número aleatorio entre 0 y 100,
    y pedir al usuario que intente adivinar ese número en un máximo de 5 intentos.
    En cada intento, el programa debe informar si el número ingresado por el usuario es mayor o menor que el número generado.
    */
    private static void guessTheNumber(){
        Random random= new Random();
        int rand = random.nextInt(100);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 100:");
        for (int i = 1; i < 6; i++ ) {
            System.out.println("Attempts: " + i + " of 5");
            int userNumber = sc.nextInt();
            if(userNumber == rand){
                System.out.println("Winner!");
                break;
            }else if(userNumber > rand){
                System.out.println("Sorry, your number is greater");
            }else{
                System.out.println("Sorry, your number is smaller");
            }
        }
        System.out.println("The hidden number was: " + rand);
    }
    
    /* Programa que simule transacciones bancarias.
    Inicializar un cliente con nombre, tipo de cuenta y saldo disponible.
    Solicitar el número de la opción deseada entre consultar saldo, retirar, depositar o salir.
    Mostrar resultados según selección.
    */
    private static void bank(){
        Scanner sc = new Scanner(System.in);
        String name = "John Doe";
        String account = "Checking";
        double balance = 999.99;
        System.out.println("*************************************************");
        System.out.println("RESUME");
        System.out.println("=================================================");
        System.out.println("Customer name:" + name);
        System.out.println("Account type: " + account);
        System.out.println("Current balance: U$D " + balance);
        System.out.println("=================================================");
        int option = 0;
        do {
            System.out.println("\n** Choose a number of option **");
            System.out.println("1 - Get current balance");
            System.out.println("2 - Withdraw money");
            System.out.println("3 - Deposit money");
            System.out.println("9 - Exit");
            System.out.println("*********************************************");
            double amount = 0;
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("\tCurrent balance: U$D " + balance);
                    break;
                case 2:
                    System.out.print("\tAmount to withdraw: U$D ");
                    amount = sc.nextDouble();
                    if(amount > balance){
                        System.out.println("\tSorry, Insufficient funds");
                    } else {
                        balance -= amount;
                        System.out.println("\tNew balance: U$D" + balance);
                    }
                    break;
                case 3:
                    System.out.print("\tAmount to deposit: U$D ");
                    amount = sc.nextDouble();
                    balance += amount;
                    System.out.println("\tNew balance: U$D " + balance);
                    break;
                case 9:
                    System.out.println("\tProgram finished, thanks for use our services.\n");
                    break;
                default:
                    System.out.println("\tInvalid option, try again please");
            }
        } while(option != 9);
    }
}