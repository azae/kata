package rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.DoubleBinaryOperator;

public class RPNCalculatorLambda {
    public static double compute(String rpnString) throws Exception {
        String[] operands = rpnString.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = operands.length; i > 0; i--) {
            stack.push(operands[i - 1]);
        }

        boolean stackNotEmpty = true;
        while (stackNotEmpty) {
            List<Double> operandes = new ArrayList<>();
            Operator operator = null;
            boolean notOperator = true;
            while (notOperator) {
                String element = stack.pop();
                try {
                    operandes.add(Double.parseDouble(element));
                } catch (NumberFormatException e) {
                    notOperator = false;
                    operator = Operator.getFromSymbol(element);
                }
            }

            if (stack.empty())
                stackNotEmpty = false;
            stack.push(String.valueOf(operator.compute(operandes)));
        }
        return Double.parseDouble(stack.pop());
    }

    private enum Operator {
        DIVIDE("/", (a, b) -> a / b),
        MULTIPLY("*", (a, b) -> a * b),
        ADD("+", (a, b) -> a + b),
        SQRT("SQRT", (a, b) -> Math.sqrt(a));
        private final String symbol;
        private final DoubleBinaryOperator function;

        Operator(String symbol, DoubleBinaryOperator binaryOperator) {
            this.symbol = symbol;
            this.function = binaryOperator;
        }

        public double compute(final List<Double> operandes) {
            double left = operandes.get(0);
            double right = 0;
            if (operandes.size() == 2)
                right = operandes.get(1);

            return function.applyAsDouble(left, right);
        }

        public String getSymbol() {
            return symbol;
        }

        public static Operator getFromSymbol(String symbol) throws Exception {
            for (Operator operator : Operator.values()) {
                if (operator.getSymbol().equals(symbol)) return operator;
            }
            throw new Exception("Operator " + symbol + " not found");
        }

    }
}
