import java.util.*;
public class CoffeeMachine {

    /**
     * Print to stdin the given amount of resources
     */
    public static void print(int water, int milk, int beans, int cups, int money, int whiskey, int chocolateSyrup) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(whiskey + " of whiskey");
        System.out.println(chocolateSyrup + " of chocolateSyrup");
        System.out.println("$" + money + " of money");
    }

    /**
     * Check if there is enough resources to make a given coffee type
     */
    public static boolean isEnough(String type, int water, int milk, int beans, int cups,int chocolateSyrup,int whiskey) {
        boolean enough = false;

        int waterLimit;
        int milkLimit;
        int beansLimit;
        int chocolateSyrupLimit = 0;
        int whiskeyLimit = 0;
        switch (type) {
            case "1": // black
                waterLimit = 250;
                milkLimit = 0;
                beansLimit = 10;
                break;
            case "2": // latte
                waterLimit = 40 ;
                milkLimit = 300;
                beansLimit = 20;
                break;
            case "3": // cappuccino
                waterLimit = 40;
                milkLimit = 85;
                beansLimit = 20;
                break;
            case "4": // espresso
                waterLimit = 20;
                milkLimit = 0;
                beansLimit = 10;
                break;
            case "5": // americano
                waterLimit = 130;
                milkLimit = 0;
                beansLimit = 20;
                break;
            case "6": // macchiato
                waterLimit = 20;
                milkLimit = 5;
                beansLimit = 10;

                break;
            case "7": // mocha
                waterLimit = 10;
                milkLimit = 20;
                beansLimit = 5;
                chocolateSyrupLimit = 15;
                break;
            case "8": // flat white
                waterLimit = 20;
                milkLimit = 200;
                beansLimit = 10;
                break;
            case "9": // irish coffee
                waterLimit = 40;
                milkLimit = 100;
                beansLimit = 20;
                whiskeyLimit = 20;
                break;
            default:
                return false;
        }
        if (water < waterLimit) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkLimit) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansLimit) {
            System.out.println("Sorry, not enough coffee beans!");
        }else if (whiskey < whiskeyLimit){
            System.out.println("Sorry, not enough whiskey!");
        }else if (chocolateSyrup< chocolateSyrupLimit) {
            System.out.println("Sorry, not enough chocolateSyrup!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            enough = true;
            System.out.println("I have enough resources, making you a coffee!");
        }
        return enough;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 500;
        int milk = 500;
        int beans = 150;
        int cups = 10;
        int money = 100;
        int whiskey = 100;
        int chocolateSyrup = 50;
        while (true) {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String command = (scanner.next()).toLowerCase();
            System.out.println();

            switch (command) {
                case "buy":
                    System.out.print("What would you want to buy today enter the respective number ?\n 1 - Black, 2 - Latte, 3 - Cappuccino\n" + " 4 - Espresso shot , 5 - Americano, 6 - Macchiato,\n" +
                            " 7 - mocha, 8 -Flat White, 9 - Irish Coffee \n" +
                            "Back - to go back to the  main menu:\n");
                    String type = scanner.next();// Input for type of coffee
                    boolean enough = isEnough(type, water, milk, beans, cups,chocolateSyrup,whiskey);
                    switch (type) {
                        case "1": // Black
                            if (enough) {
                                water -= 250;
                                beans -= 10;
                                cups -= 1;
                                money += 4;
                            }
                            break;
                        case "2": // Latte
                            if (enough) {
                                water -= 40;
                                milk -= 300;
                                beans -= 20;
                                cups -= 1;
                                money += 7;
                            }
                        case "3": // Cappuccino
                            if (enough) {
                                water -= 40;
                                milk -= 85;
                                beans -= 20;
                                cups -= 1;
                                money += 6;
                            }
                            break;
                        case "4": // Espresso
                            if (enough) {
                                water -= 20;
                                milk -= 0;
                                beans -= 10;
                                cups -= 1;
                                money += 2;
                            }
                        case "5": // Americano
                            if (enough) {
                                water -= 130;
                                milk -= 0;
                                beans -= 20;
                                cups -= 1;
                                money += 5;
                            }
                        case "6": // Macchiato
                            if (enough) {
                                water -= 20;
                                milk -= 5;
                                beans -= 10;
                                cups -= 1;
                                money += 5;
                            }
                        case "7": // Mocha
                            if (enough) {
                                water -= 10;
                                milk -= 20;
                                beans -= 5;
                                chocolateSyrup -= 10;
                                cups -= 1;
                                money += 6;
                            }
                        case "8": // Flat White
                            if (enough) {
                                water -= 20;
                                milk -= 200;
                                beans -= 10;
                                cups -= 1;
                                money += 7;
                            }
                        case "9": // Irish Coffee
                            if (enough) {
                                water -= 40;
                                milk -= 100;
                                beans -= 20;
                                whiskey -= 20;
                                cups -= 1;
                                money += 8;
                            }
                            break;
                        case "back":// In case of back break and go back
                            break;
                        default:
                            System.out.println("Unknown coffee type");// Setting default case to invalid input
                            break;
                    }
                    break;
                case "fill":
                    //Use of try catch block just in case user enters something other than an INTEGER
                    // because no one likes to see red lines of code in the terminal
                    try
                    {
                        System.out.print("Write how many ml of water do you want to add: "); // For adding water
                        water += scanner.nextInt(); // Updating value of water
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer."); // Error message
                        break;
                    }
                    try
                    {
                        System.out.print("Write how many ml of milk do you want to add: ");// For adding milk
                        milk += scanner.nextInt(); // Updating value of milk
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer."); // Error message
                        break;
                    }
                    try
                    {
                        System.out.print("Write how many grams of coffee beans do you want to add: "); // For adding coffee beans
                        beans += scanner.nextInt();//Updating value of coffee beans
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer.");//Error message
                        break;
                    }
                    try
                    {
                        System.out.print("Write how many disposable cups of coffee do you want to add: ");// Adding number of cups
                        cups += scanner.nextInt();//Updating number of cups
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer.");//Error message
                        break;
                    }
                    try
                    {
                        System.out.print("Write how many ml of whiskey do you want to add: ");//Adding whiskey
                        whiskey += scanner.nextInt();//Updating whiskey
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer.");//Error message
                        break;
                    }
                    try
                    {
                        System.out.print("Write how many ml of chocolate syrup do you want to add: ");// Adding cho
                        chocolateSyrup += scanner.nextInt();// Updating chocolate syrup
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        break;
                    }

                case "take":
                        System.out.printf("I gave you $%s\n", money);// This case is for taking the money collected after coffee orders
                        money = 0; // Resetting the value of money to zero as we just took all the money out
                        break;
                case "remaining":
                        print(water, milk, beans, cups, money,whiskey,chocolateSyrup);//This case is for  Printing the remaining supplies
                        break;
                case "exit":
                        System.out.println("Thank You visit us again :) "); // This case executes the code for good :)
                        return;
                default:
                        System.out.println("Invalid Input !! "); // setting default to Invalid Input
                        break; // if the user enters something Invalid
            }

            System.out.println(); // printing empty line
        }
    }
}