package net.azae.kata.hexagonal;

import org.junit.Assert;
import org.junit.Test;

public class CreditLogicUnitTest {
    @Test
    public void testAcceptedCreditWhenGoodBalanceAndGoodSalary() {
        Assert.assertTrue("credit should be allowed", CreditLogic.allowCredit(100, 10, 1000, 500));
    }

    @Test
    public void testRejectedCreditWhenBalanceTooLow() {
        Assert.assertFalse("credit should be rejected", CreditLogic.allowCredit(100, 10, 0, 500));
    }

    @Test
    public void testRejectedCreditWhenSalaryTooLow() {
        Assert.assertFalse("credit should be rejected", CreditLogic.allowCredit(100, 10, 1000, 10));
    }

}
