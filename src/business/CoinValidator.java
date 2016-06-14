package business;

import model.Coin;

public class CoinValidator {

    public static Coin validateCoinAndReturnValue(Coin coin){
        return determineCoin(coin);
    }

    private static Coin determineCoin(Coin coin) {
        if(coin.equals(Coin.DIME)){
            return Coin.DIME;
        }
        else if(coin.equals(Coin.NICKEL)){
            return Coin.NICKEL;
        }
        else if(coin.equals(Coin.QUARTER)){
            return Coin.QUARTER;
        }
        return Coin.INVALID;
    }

    public static int determineCoinValue(Coin coin){
        if(coin.equals(Coin.DIME)){
            return 10;
        }
        else if(coin.equals(Coin.NICKEL)){
            return 5;
        }
        else if(coin.equals(Coin.QUARTER)){
            return 25;
        }
        return 0;
    }
}
