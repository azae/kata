package net.azae.kata;

class Solution {

    public static int encryptCrc(int crc, String date) {
        int key = getMagicNumber(date);
        return join(encrypt(mostSignificantBit(crc), key), encrypt(leastSignificantBit(crc), key));
    }

    private static int getMagicNumber(String date) {
        return ((Integer.valueOf(date.substring(0, 2)) + Integer.valueOf(date.substring(3, 5))) % 8);
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
        return (value ^ (value << 1)) & 0xFF;
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

