package business;

import model.Coin;
import model.CoinConstants;

import java.util.ArrayList;
import java.util.List;

public class CoinBank {

    private int quantityNickels;
    private int quantityDimes;
    private int quantityQuarters;

    private List<Coin> coinReturn = new ArrayList<>();

    public CoinBank(){
        initBank();
    }

    private void initBank() {
        quantityNickels = 10;
        quantityDimes = 10;
        quantityQuarters = 5;
    }

    public void addCoin(Coin coin){
        if(coin.equals(Coin.DIME)){
            quantityDimes++;
        }
        else if(coin.equals(Coin.NICKEL)){
            quantityNickels++;
        }
        else if(coin.equals(Coin.QUARTER)){
            quantityQuarters++;
        }
    }

    public void emptyBank(){
        quantityNickels = 0;
        quantityDimes = 0;
        quantityQuarters = 0;
    }

    public boolean canMakeChange(int amountToChangeOut){
        return (quantityDimes * 10) + (quantityNickels * 5) + (quantityQuarters * 25) >= amountToChangeOut;
    }

    public void makeChange(int amountToChangeOut){
        while(amountToChangeOut != 0){
            if(amountToChangeOut >= 25  && quantityQuarters > 0){
                amountToChangeOut -= 25;
                coinReturn.add(new Coin(CoinConstants.WEIGHT_OF_QUARTER, CoinConstants.DIAMETER_OF_QUARTER));
                quantityQuarters--;
            }
            else if(amountToChangeOut >= 10 && quantityDimes > 0){
                amountToChangeOut -= 10;
                coinReturn.add(new Coin(CoinConstants.WEIGHT_OF_DIME, CoinConstants.DIAMETER_OF_DIME));
                quantityDimes--;
            }
            else if(amountToChangeOut >= 5 && quantityNickels > 0){
                amountToChangeOut -= 5;
                coinReturn.add(new Coin(CoinConstants.WEIGHT_OF_NICKEL, CoinConstants.DIAMETER_OF_NICKEL));
                quantityNickels--;
            }
        }
    }

    public List<Coin> getCoinReturn(){
        return this.coinReturn;
    }
}
