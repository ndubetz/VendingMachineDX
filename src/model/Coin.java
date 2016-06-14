package model;

public class Coin {

    public static final Coin NICKEL  = new Coin(CoinConstants.WEIGHT_OF_NICKEL, CoinConstants.DIAMETER_OF_NICKEL);
    public static final Coin DIME    = new Coin(CoinConstants.WEIGHT_OF_DIME, CoinConstants.DIAMETER_OF_DIME);
    public static final Coin QUARTER = new Coin(CoinConstants.WEIGHT_OF_QUARTER, CoinConstants.DIAMETER_OF_QUARTER);
    public static final Coin INVALID = new Coin(Integer.MIN_VALUE, Integer.MIN_VALUE);

    private final int weight;
    private final int diameter;

    public Coin(int weight, int diameter){
        this.weight = weight;
        this.diameter = diameter;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getDiameter() {
        return this.diameter;
    }

    @Override
    public String toString(){
        if(this.equals(Coin.DIME)){
            return "Dime";
        }
        else if(this.equals(Coin.NICKEL)){
            return "Nickel";
        }
        else if(this.equals(Coin.QUARTER)){
            return "Quarter";
        }
        return "Coin with weight " + this.weight + " and diameter " + this.diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coin coin = (Coin) o;

        return weight == coin.weight && diameter == coin.diameter;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + diameter;
        return result;
    }

}
