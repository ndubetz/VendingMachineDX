package model;

import business.CoinAcceptor;
import business.CoinBank;
import ui.Display;

public class VendingMachine {

    private final Wallet wallet;
    private final CoinBank coinBank;

    public VendingMachine(Wallet wallet, CoinBank coinBank){
        this.wallet = wallet;
        this.coinBank = coinBank;
    }

    public void receiveCoin(Coin coin){
        CoinAcceptor.accept(coin, this);
        if(wallet.getCurrentAmount() == 0){
            if(coinBank.canMakeChange(50)){
                Display.displayMessage("INSERT COIN");
            }
            else{
                Display.displayMessage("EXACT CHANGE ONLY");
            }
        }
    }

    public void attemptToBuyProduct(Product product){
        if(wallet.getCurrentAmount() >= product.getPrice()){
            product.buyProduct();
            wallet.spendMoney(product.getPrice());
            if (wallet.getCurrentAmount() > 0){
                coinBank.makeChange(wallet.getCurrentAmount());
                wallet.spendMoney(wallet.getCurrentAmount());
                Display.displayMessage("THANK YOU");
            }
        }else{
            Display.displayMessage("PRICE: " + product.getDisplayPrice());
        }
    }

    public Wallet getWallet(){
        return this.wallet;
    }
    public CoinBank getCoinBank() {
        return this.coinBank;
    }
}
