package net.azae.kata.wrap;

public class WrapTailRecursive {

    public String wrapLine(String remaining, int maxLength) {
        StringBuilder output = new StringBuilder();
        wrapLineTail(remaining, maxLength, output);
        return output.toString();
    }

    private void wrapLineTail(String remaining, int maxLength, StringBuilder accumulator) {
        if (remaining.length() <= maxLength) {
            accumulator.append(remaining);
        } else {

            int split = remaining.lastIndexOf(" ", maxLength);

            accumulator.append(remaining.substring(0, split) + "\n");
            wrapLineTail(remaining.substring(split + 1), maxLength, accumulator);
        }
    }
}
