package com.khpi.demo.util.filler.impl;

import com.khpi.demo.util.filler.ByteFiller;

public class TwoBytesFiller implements ByteFiller {

    @Override
    public byte[] fill(byte []bytesParam) {
        byte []bytes = new byte[2];
        bytes[0] = bytesParam[bytesParam.length - 2];
        bytes[1] = bytesParam[bytesParam.length - 1];
        return bytes;
    }
}
