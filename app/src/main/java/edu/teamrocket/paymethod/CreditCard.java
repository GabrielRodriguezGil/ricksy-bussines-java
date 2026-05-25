package edu.teamrocket.paymethod;

public class CreditCard implements PaymentMethod {
    private final String owner;
    private final String number;
    private double credit = 3000;
    private static final String SYMBOL = "EFI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    @Override
    public boolean pay(double precio) {
        if ((credit - precio) >= 1) {
            credit -= precio;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String number() {
        return this.number;
    }

    @Override
    public String cardOwner() {
        return this.owner;
    }

    @Override
    public double credit() {
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