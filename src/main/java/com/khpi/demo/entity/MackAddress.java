package com.khpi.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class MackAddress {

    public static final byte REMINDER_CONDITION = -1;

    public static final int NUMBER_BYTES = 6;

    private byte[] address;

    public MackAddress(byte[] bytes) {
        address = new byte[NUMBER_BYTES];
        int putIndex = NUMBER_BYTES - bytes.length;
        if (putIndex < 0) {
            putIndex = 0;
        }
        for (int i = putIndex; i < NUMBER_BYTES; i++) {
            address[i] = bytes[bytes.length - (NUMBER_BYTES - i)];
        }
        for (int i = 0; i < putIndex; i++) {
            address[i] = 0;
        }
    }

    public MackAddress getIncrement() {
        byte newAddress[] = address.clone();
        int index = address.length - 1;
        boolean remainder = true;
        while (remainder && index >= 0) {
            if (newAddress[index] != REMINDER_CONDITION) {
                remainder = false;
            }
            newAddress[index]++;
            index--;
        }
        return new MackAddress(newAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MackAddress that = (MackAddress) o;
        return Arrays.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(address);
    }

    @Override
    public String toString() {
        String result = "";
        for (Byte b : this.address) {
            result += (b < 16 ? "0" : "") + Integer.toHexString(0xFF & b);
        }
        return result;
    }
}
