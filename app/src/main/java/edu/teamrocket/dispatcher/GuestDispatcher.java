package edu.teamrocket.dispatcher;

import edu.teamrocket.paymethod.PaymentMethod;

public interface GuestDispatcher {
    public void dispatch(PaymentMethod card);
}