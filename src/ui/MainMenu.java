package ui;

import business.CoinBank;
import model.Coin;
import model.Product;
import model.VendingMachine;
import model.Wallet;

import java.util.Scanner;

public class MainMenu {

    private static String input = "";
    private static Scanner scanner;
    private static final VendingMachine vendingMachine = new VendingMachine(new Wallet(), new CoinBank());

    public static void start(){

        welcome();
        scanner = new Scanner(System.in);

        while(!input.equalsIgnoreCase("q")){
            displayMainMenu();
            input = scanner.next();
            processInput(input);
        }

        scanner.close();
        quit();
    }

    private static void displayMainMenu() {
        System.out.println("Choose an option:");
        System.out.println("1 - Insert Coin");
        System.out.println("2 - Select Product");
        System.out.println("3 - Make Change");
        System.out.println("4 - Get Coins from Coin Return");
        System.out.println("5 - Remove coins from machine");
    }

    private static void processInput(String input) {
        switch (input){
            case "1":
                displayInsertCoinMenu();
                break;
            case "2":
                displaySelectProductMenu();
                break;
            case "3":
                makeChange();
                break;
            case "4":
                getCoinsFromCoinReturn();
                break;
            case "5":
                removeCoinsFromCoinMachine();
                break;
            default:
                System.out.println("ERROR: Input not valid.");
                System.out.println("");
                break;
        }
    }

    private static void getCoinsFromCoinReturn() {
        System.out.println("Coins in coin return:");
        for (Coin coin:
                vendingMachine.getCoinBank().getCoinReturn()) {
            System.out.print(coin);
        }
    }

    private static void makeChange() {
        if(vendingMachine.getCoinBank().canMakeChange(vendingMachine.getWallet().getCurrentAmount())){
            System.out.println("");
            System.out.println("Making change");
            vendingMachine.getCoinBank().makeChange(vendingMachine.getWallet().getCurrentAmount());
        }
        else{
            System.out.println("Cannot make change.");
        }
    }

    private static void removeCoinsFromCoinMachine() {
        System.out.println("");
        System.out.println("Removing coins from coin machine");
        vendingMachine.getCoinBank().emptyBank();
    }

    private static void displaySelectProductMenu() {
        System.out.println("");
        System.out.println("Select a product:");
        System.out.println("1 - Cola");
        System.out.println("2 - Chips");
        System.out.println("3 - Candy");
        input = scanner.next();
        switch (input){
            case "1":
                vendingMachine.attemptToBuyProduct(Product.COLA);
                break;
            case "2":
                vendingMachine.attemptToBuyProduct(Product.CHIPS);
                break;
            case "3":
                vendingMachine.attemptToBuyProduct(Product.CANDY);
                break;
            default:
                System.out.println("ERROR: Input not valid.");
                System.out.println("");
                break;
        }
    }

    private static void displayInsertCoinMenu() {
        System.out.println("");
        System.out.print("Enter the weight and diameter of the coin, separated by a space: ");

        try{
            final int weight = scanner.nextInt();
            final int diameter = scanner.nextInt();
            vendingMachine.receiveCoin(new Coin(weight, diameter));
            System.out.print("Insert more coins (y/n): ");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("y")){
                displayInsertCoinMenu();
            }
            else{
                System.out.println("Done inserting coins.");
                System.out.println("");
            }
        } catch (Exception e){
            System.out.println("Invalid input. Try again");
            displayInsertCoinMenu();
        }
    }

    private static void quit() {
        System.out.println("Thank you for using the Vending Machine!");
    }

    private static void welcome() {
        System.out.println("Welcome to the Vending Machine. Press q at any time to quit");
    }
}
