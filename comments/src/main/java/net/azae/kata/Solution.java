package net.azae.kata;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    private final static DateFormat formatter = new SimpleDateFormat("dd/MM");
    
    public static int encryptCrc(final int crc, final String date) throws ParseException {
    	final int salt = getSalt(formatter.parse(date));
        return join(encrypt(mostSignificantBit(crc), salt), encrypt(leastSignificantBit(crc), salt));
    }

    private static int getSalt(final Date date) {
    	final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return ((calendar.get(DAY_OF_MONTH) + calendar.get(MONTH) +1 ) % 8);
    }

    private static int leastSignificantBit(final int value) {
        return value & 0xFF;
    }

    private static int mostSignificantBit(int value) {
        return (value >> 8) & 0xFF;
    }

    private static int join(final int msb, final int lsb) {
        return msb << 8 | lsb;
    }

    private static int encrypt(final int value, final int salt) {
        final int rotated = rotateRight(value, salt);
        return ((rotated << 1) ^ rotated) & 0xFF;
    }

    private static int rotateRight(final int value, final int count) {
    	int rotated = value;
        for (int i = 0; i < count; ++i) {
            if ((rotated & 0x01) != 0)
            	rotated = (0x80 | (rotated >> 1));
            else
            	rotated = (rotated >> 1);
        }
        return rotated;
    }

}

