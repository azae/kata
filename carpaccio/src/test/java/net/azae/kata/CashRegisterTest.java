package net.azae.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    private static final double DELTA = 1e-15;

    @Test
    public void should_return_same_price_with_1_unit() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setUnitPrice(12);
        assertEquals(12, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void should_return_good_price_with_2_products_and_1_price() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setUnitPrice(12);
        cashRegister.setQuantity(2);
        assertEquals(24, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void test_CashRegister_with_2_products_1_unit_price_in_TX() {
        CashRegister cashRegister = getCashRegister("TX");
        assertEquals(25.5, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void test_CashRegister_with_2_product_1_unit_price_in_UT() {
        CashRegister cashRegister = getCashRegister("UT");
        assertEquals(25.64, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void test_CashRegister_with_2_product_1_unit_price_in_NV() {
        CashRegister cashRegister = getCashRegister("NV");
        assertEquals(25.92, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void should_return_good_price_whit_discount_level_1000 () {
        CashRegister cashRegister = getCashRegister("AL");
        cashRegister.setQuantity(200);
        assertEquals(2421.12, cashRegister.getPrice(), DELTA);
    }

    @Test
    public void should_return_good_price_whit_discount_level_5000 () {
        CashRegister cashRegister = getCashRegister("CA");
        cashRegister.setQuantity(500);
        assertEquals(6170.25, cashRegister.getPrice(), DELTA);
    }

    private CashRegister getCashRegister(String state) {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setUnitPrice(12);
        cashRegister.setQuantity(2);
        cashRegister.setTaxe(state);
        return cashRegister;
    }

}
