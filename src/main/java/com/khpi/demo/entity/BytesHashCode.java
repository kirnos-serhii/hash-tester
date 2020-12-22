package com.khpi.demo.entity;

import com.khpi.demo.exception.HashAlgorithmTesterRuntimeException;
import com.khpi.demo.util.filler.ByteFiller;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.util.Arrays;

@Getter
@Setter
public class BytesHashCode implements HashCode {

    private byte[] bytes;

    public BytesHashCode(byte[] bytesParam, ByteFiller filler) {
        if (bytesParam.length < 2) {
            throw new HashAlgorithmTesterRuntimeException("Incorrect hash result.");
        }

        bytes = filler.fill(bytesParam);
    }

    public BytesHashCode(Long longParam, ByteFiller filler) {
        byte []bytesParam = longToBytes(longParam);

        bytes = filler.fill(bytesParam);
    }

    public BytesHashCode(Integer intParam, ByteFiller filler) {
        byte []bytesParam = intToBytes(intParam);

        bytes = filler.fill(bytesParam);
    }

    private byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    private byte[] intToBytes(int x) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(x);
        return buffer.array();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BytesHashCode that = (BytesHashCode) o;
        return Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        ByteBuffer wrapped = ByteBuffer.wrap(bytes);
        if (bytes.length == 2) {
            return wrapped.getShort();
        } else {
            return wrapped.getInt();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Byte b : this.bytes) {
            result += (b < 16 ? "0" : "") + Integer.toHexString(0xFF & b);
        }
        return result;
    }
}
