package edu.teamrocket.paymethod;

public interface PaymentMethod {

    public boolean pay(double precio);

    String number();

    String cardOwner();

    double credit();

}