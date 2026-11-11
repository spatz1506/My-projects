import java.util.Scanner;

public class Cafe {
    public static void main(String[] args) {
        // Initialize the scanner to read user's input
        Scanner input = new Scanner(System.in);
        //drinkChoice means the user's selection of a drink (1 for coffee, 2 for tea, 3 for hot chocolate)
        int drinkChoice = 3;
        //set the default drink name and price based on the initial drinkChoice
        String drinkName = "Coffee";
        drinkName = "Tea";
        drinkName = "Hot chocolate";
        //use double for the price and subtotal to handle decimal values
        double price = 2.50;
        price = 1.50;
        price = 3.50;
        //subtotal will start at 0 and accumulate the total cost of the selected drinks
        double subtotal = 0;
        //valid means whether the user's drink choice is valid (true) or not (false)
        boolean valid = false;
        
        System.out.println("Welcome to the Cafe!");
        System.out.println("Please select a drink:");
        System.out.println("1. coffee - 2.50$");
        System.out.println("2. tea - 1.50$");
        System.out.println("3. hot chocolate - 3.50$");
        System.out.print("Enter your choice (1-3): ");
        //read the user's initial drink choice
        drinkChoice = input.nextInt();

        // Process the user's drink choice
        switch (drinkChoice) {
            case 1:
                drinkName = "Coffee";
                price = 2.50;
                valid = true;
                break;
            case 2:
                drinkName = "Tea";
                price = 1.50;
                valid = true;
                break;
            case 3:
                drinkName = "Hot chocolate";
                price = 3.50;
                valid = true;
                break;
            default:
                System.out.println("Invalid choice.");
                //exit the program if the drink choice is invalid
                return;
        }
        System.out.println("How many would you like?");
        int quantity = input.nextInt();
        //add the cost of the selected quantity to the subtotal
        subtotal += price * quantity;
        System.out.println("anything else you'd like to order?");
        
        //loop to allow the user to place additional drink orders until they choose to finish ordering
        int choice;
        do {
            System.out.print("Enter your choice (1-3) or 0 to finish ordering: ");
            choice = input.nextInt();
            //if the user enters 0, the loop will terminate
            if (choice != 0) {
                // Process the user's additional drink choice
                switch (choice) {
                    case 1:
                        drinkName = "Coffee";
                        price = 2.50;
                        valid = true;
                        break;
                    case 2:
                        drinkName = "Tea";
                        price = 1.50;
                        valid = true;
                        break;
                    case 3:
                        drinkName = "Hot chocolate";
                        price = 3.50;
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
                //read the quantity for the selected drink
                System.out.println("How many would you like?");
                quantity = input.nextInt();
                //add the cost of the selected quantity to the subtotal
                subtotal += price * quantity;
                System.out.println("You selected " + quantity + " " + drinkName + " for $" + price);
            }
            //check if the user wants to place another order. if user enters 0, the loop will terminate and finish ordering
        } while (choice != 0);

        System.out.println("Subtotal: $" + subtotal);
        // 8% tax
        double tax = subtotal * 0.08;
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + (subtotal + tax));
    }
}