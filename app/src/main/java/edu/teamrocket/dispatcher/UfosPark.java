package edu.teamrocket.dispatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.teamrocket.paymethod.PaymentMethod;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private Map<String, String> flota = new HashMap<>();

    public UfosPark() {
    }

    public void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }

    @Override
    public void dispatch(PaymentMethod card) {

        String ufo = null;

        if (!flota.containsValue(card.number())) {
            ufo = flota.entrySet().stream().filter(x -> x.getValue() == null).map(Entry::getKey).findFirst()
                    .orElse(null);
        }
        if (ufo != null && card.pay(fee)) {
            flota.put(ufo, card.number());
        }
    }

    public String getUfoOf(String ownerCard) {
        return flota.entrySet().stream().filter(x -> x.getValue().equals(ownerCard)).map(Entry::getKey)
                .findFirst().orElse(null);
    }

    boolean containsCard(String cardId) {
        return flota.containsValue(cardId);
    }

    public Collection<String> cardNumbers() {
        return flota.values();
    }

    @Override
    public String toString() {
        String[] ufosID = this.flota.keySet().toArray(new String[flota.size()]);
        Arrays.sort(ufosID);
        return List.of(ufosID).toString();
    }
}