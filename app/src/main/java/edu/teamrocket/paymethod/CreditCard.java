package edu.teamrocket.paymethod;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000;
    private static final String SYMBOL = "EFI";

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    boolean pay(double precio) {
        if ((credit - precio) >= 1) {
            credit -= precio;
            return true;
        } else {
            return false;
        }

    }

    String number() {
        return this.number;
    }

    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("owner: " + owner);
        resultado.append("number: " + number);
        resultado.append("credit: " + Double.toString(credit) + SYMBOL);

        return resultado.toString();
    }
    
}