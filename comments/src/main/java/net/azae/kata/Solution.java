package net.azae.kata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;

class Solution {
    private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
    
    public static int encryptCrc(int crc, String date) throws ParseException {
        int key = getMagicNumber(formatter.parse(date));
        return join(encrypt(mostSignificantBit(crc), key), encrypt(leastSignificantBit(crc), key));
    }

    private static int getMagicNumber(Date date) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return ((calendar.get(DAY_OF_MONTH) + calendar.get(MONTH)) % 8);
    }

    private static int leastSignificantBit(int value) {
        return value & 0xFF;
    }

    private static int mostSignificantBit(int value) {
        return (value >> 8) & 0xFF;
    }

    private static int join(int msb, int lsb) {
        return msb << 8 | lsb;
    }

    private static int encrypt(int value, int count) {
        value = rotateRight(value, count);
        return ((value << 1) ^ value) & 0xFF;
    }

    private static int rotateRight(int value, int count) {
        for (int i = 0; i < count; ++i) {
            if ((value & 0x01) != 0)
                value = (0x80 | (value >> 1));
            else
                value = (value >> 1);
        }
        return value;
    }

}

