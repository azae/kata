package net.azae.kata.crc;

class Original {
    /*
     * date: should be dd/mm
     */
    public static int encryptCrc(int crc, String date) {
        int day = Integer.valueOf(date.substring(0, 2));
        int month = Integer.valueOf(date.substring(3, 5));
        int remainder = ((day + month) % 8);

        int[] msbLsb = new int[2];  // MSB in 0, LSB in 1
        msbLsb[0] = (crc & 0xFF00) >> 8;
        msbLsb[1] = crc & 0xFF;

        int result = 0;
        for (int i = 0; i < 2; i++) {
            // Right rotation
            for (int j = 0; j < remainder; j++) {
                if ((msbLsb[i] & 0x01) != 0)
                    msbLsb[i] = (0x80 | (msbLsb[i] >> 1));
                else
                    msbLsb[i] = (msbLsb[i] >> 1);
            }
            // Memorize, then left translation
            int temp = msbLsb[i];
            msbLsb[i] = (msbLsb[i] << 1);
            // XOR
            msbLsb[i] = (msbLsb[i] ^ temp) & 0xFF;
            // Add to result
            result = result << 8 | msbLsb[i];
        }
        // Return crc value
        return result;
    } // encryptCrc
}

