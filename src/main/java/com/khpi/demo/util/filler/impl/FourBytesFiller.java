package com.khpi.demo.util.filler.impl;

import com.khpi.demo.util.filler.ByteFiller;

public class FourBytesFiller implements ByteFiller {

    @Override
    public byte[] fill(byte []bytesParam) {
        byte []bytes = new byte[4];
        bytes[0] = bytesParam[bytesParam.length - 4];
        bytes[1] = bytesParam[bytesParam.length - 3];
        bytes[2] = bytesParam[bytesParam.length - 2];
        bytes[3] = bytesParam[bytesParam.length - 1];
        return bytes;
    }
}
