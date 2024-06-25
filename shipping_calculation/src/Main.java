
//HyerynByeon, 24605137

import java.util.Scanner;
import containers.BigContainer;
import containers.Container;
import containers.SmallContainer;
import items.Item;
import methods.Calculation;

public class Main {
    public static void main(String[] args) {
        //Creating items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcdScreens = new Item("LCD screens", 120, 140, 80, 2.6);

        //Creating containers
        Container smallContainer = new SmallContainer(259, 243, 606);
        Container bigContainer = new BigContainer(259, 243, 1201);
        
        double smallContainerVolume = smallContainer.calculateVolume();
        double bigContainerVolume = bigContainer.calculateVolume();
        
        System.out.println("Small Container Volume: " + smallContainerVolume + " cm^3");
        System.out.println("Big Container Volume: " + bigContainerVolume + " cm^3");

        //Creating calculation instance
        Calculation calculation = new Calculation();

        //Getting quantity for each item from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the quantity for Laptop: ");
        int laptopQuantity = scanner.nextInt();
        System.out.print("Enter the quantity for Mouse: ");
        int mouseQuantity = scanner.nextInt();
        System.out.print("Enter the quantity for Desktop: ");
        int desktopQuantity = scanner.nextInt();
        System.out.print("Enter the quantity for LCD screens: ");
        int lcdQuantity = scanner.nextInt();
        scanner.close();


        //Adding items and order
        for (int i = 0; i < laptopQuantity; i++) {
            calculation.addItems(laptop);
        }
        
        for (int i = 0; i < mouseQuantity; i++) {
            calculation.addItems(mouse);
        }
        
        for (int i = 0; i < desktopQuantity; i++) {
            calculation.addItems(desktop);
        }
        
        for (int i = 0; i < lcdQuantity; i++) {
            calculation.addItems(lcdScreens);
        }

        //Printing item information
        calculation.printItemInfo();
        System.out.println();

        //Printing order information
        System.out.println("Order:");
        System.out.println(laptopQuantity + "x Laptop");
        System.out.println(mouseQuantity + "x Mouse");
        System.out.println(desktopQuantity + "x Desktop");
        System.out.println(lcdQuantity + "x LCD screens");

        //Calculating best shipping method
        calculation.bestShipping(bigContainer, smallContainer);
        
        //
        System.out.println("---------------------------------------");
        System.out.println("Hyeryn Byeon");
    }
}


