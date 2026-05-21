package edu.teamrocket.dispatcher;

import edu.teamrocket.paymethod.CreditCard;

public interface GuestDispatcher {
    public void dispatch(CreditCard card);
}