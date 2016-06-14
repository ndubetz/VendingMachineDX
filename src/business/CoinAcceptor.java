package business;

import model.Coin;
import model.VendingMachine;
import ui.Display;

public class CoinAcceptor {

    public static void accept(Coin coin, VendingMachine vendingMachine){
        coin = CoinValidator.validateCoinAndReturnValue(coin);
        if(!coin.equals(Coin.INVALID)){
            vendingMachine.getWallet().addMoney(CoinValidator.determineCoinValue(coin));
            vendingMachine.getWallet().displayCurrentAmount();
            vendingMachine.getCoinBank().addCoin(coin);
        }
        else{
            vendingMachine.getCoinBank().getCoinReturn().add(coin);
            Display.displayMessage("COIN REJECTED");
        }
    }
}
