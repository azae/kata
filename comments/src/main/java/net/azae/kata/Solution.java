package net.azae.kata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

class Solution {
    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM");

    public static int encryptCrc(final int crc, final String date) throws ParseException {
        final int salt = getSalt(FORMATTER.parse(date));
        return join(encrypt(mostSignificantByte(crc), salt), encrypt(leastSignificantByte(crc), salt));
    }

    private static int getSalt(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (calendar.get(DAY_OF_MONTH) + calendar.get(MONTH) + 1) % 8;
    }

    private static int leastSignificantByte(final int value) {
        return value & 0xFF;
    }

    private static int mostSignificantByte(final int value) {
        return value >> 8 & 0xFF;
    }

    private static int join(final int msb, final int lsb) {
        return msb << 8 | lsb;
    }

    private static int encrypt(final int value, final int salt) {
        final int rotated = rotateByteRight(value, salt);
        return (rotated << 1 ^ rotated) & 0xFF;
    }

    public static int rotateByteRight(final int value, final int count) {
        int rotated = value;
        for (int i = 0; i < count; ++i) {
            if ((rotated & 0x01) == 0) {
                rotated >>= 1;
            } else {
                rotated = 0x80 | rotated >> 1;
            }
        }
        return rotated;
    }

    public static int rotr(final int value, final int count) {
        final int right = value >>> count;
        final int left = value << 8 - count & 0xFF;
        return (left | right) & 0xFF;
    }

    public static String render(final int value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(" ", "0");
    }

    private Solution() {
    }
}
