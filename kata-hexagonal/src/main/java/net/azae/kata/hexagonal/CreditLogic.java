package net.azae.kata.hexagonal;

public class CreditLogic {
    public static boolean allowCredit(final int amount, final int months, final int balance, final int salary) {
        return !hasEnoughBalance(balance, amount) && !hasEnoughSalary(salary, amount / months);
    }

    public static boolean hasEnoughBalance(final int balance, final int amount) {
        return balance < amount * 0.1;
    }

    public static boolean hasEnoughSalary(final int salary, final int monthly) {
        return salary < monthly * 3;
    }

}
