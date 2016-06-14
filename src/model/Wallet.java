package model;

import ui.Display;

public class Wallet {

    private int currentAmount;

    public Wallet(){
        this.currentAmount = 0;
    }

    public void addMoney(int value){
        this.currentAmount += value;
    }

    public void spendMoney(int value) {
        this.currentAmount -= value;
    }

    public int getCurrentAmount(){
        return this.currentAmount;
    }

    public void displayCurrentAmount(){
        double displayAmount = (double) currentAmount / 100.0;
        Display.displayMessage("$" + displayAmount);
    }
}
