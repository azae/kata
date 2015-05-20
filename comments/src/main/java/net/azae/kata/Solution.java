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
    
    public static int encryptCrc(int crc, String date) throws ParseException {
        int salt = getSalt(formatter.parse(date));
        return join(encrypt(mostSignificantBit(crc), salt), encrypt(leastSignificantBit(crc), salt));
    }

    private static int getSalt(Date date) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return ((calendar.get(DAY_OF_MONTH) + calendar.get(MONTH) +1 ) % 8);
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

    private static int encrypt(int value, int salt) {
        value = rotateRight(value, salt);
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

