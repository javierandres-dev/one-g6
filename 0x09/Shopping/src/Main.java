import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();

        boolean exit = false;
        int cardLimit;

        System.out.println("Enter card limit:");
        cardLimit = sc.nextInt();
        final int initialCardLimit = cardLimit;

        do {
            System.out.println("enter the product name:");
            final String nameProduct = sc.next();
            System.out.println("enter the product price:");
            final int priceProduct = sc.nextInt();

            if (cardLimit >= priceProduct) {
                cardLimit -= priceProduct;
                Product product = new Product(nameProduct, priceProduct);
                products.add(product);
                System.out.println("Done!");
                System.out.println("Current balance: " + cardLimit);
            } else {
                System.out.println("Oops!\nInsufficient funds");
                System.out.println("Current balance: " + cardLimit);
            }

            if (cardLimit == 0) {
                exit = true;
            } else {
                System.out.println("Enter '1' to continue or enter '0' to exit:");
                final byte selected = sc.nextByte();
                if (selected == 0) {
                    exit = true;
                }
            }
        } while (!exit);

        System.out.println("**** SUMMARY ****");
        System.out.println("Initial balance: " + initialCardLimit);
        System.out.println("------------------------");
        System.out.println("\t# | Product | Price");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("\t" + (i + 1) + " | " + product.name + " | " + product.price);
        }
        System.out.println("------------------------");
        System.out.println("Final balance: " + cardLimit);
    }
}