package net.azae.kata;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CashRegister {
    private static final ImmutableMap<String, Double> taxes = ImmutableMap.of("UT", 6.85, "NV", 8.0, "TX", 6.25, "AL", 4.0, "CA", 8.25);
    private static final ImmutableMap<Integer, Double> discount = ImmutableMap.of(1000, 3.0, 5000, 5.0, 7000, 7.0, 10000, 10.0, 50000, 15.0);

    private int quantity = 1;
    private double unitPrice;
    private double taxe = 0;

    public double getPrice() {
        return round(getRealPrice());
    }

    public double getRealPrice() {
        double price = quantity * unitPrice * (1 + taxe / 100);
        price = applyDiscount(price);
        return price;
    }

    private double applyDiscount(double price) {
        List<Integer> levels = new ArrayList<>(discount.keySet());
        Collections.sort(levels);
        Collections.reverse(levels);
        for (Integer level : levels) {
            System.out.println(price + " / " + level);
            if (price > level)
                return price - (price * discount.get(level) / 100);
        }
        return price;
    }

    private double round(double number) {
        return Math.round(100 * number) / 100.0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(String etat) {
        this.taxe = taxes.get(etat);
    }

}
