package com.khpi.demo.service.algorithm.impl;

import com.khpi.demo.entity.BytesHashCode;
import com.khpi.demo.entity.HashCode;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.service.algorithm.Algorithm;
import com.khpi.demo.util.filler.ByteFiller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;

@Component
@AllArgsConstructor
public class CRC32Algorithm implements Algorithm {

    private CRC32 crc32;

    @Override
    public List<HashCode> execute(Set<MackAddress> mackAddresses, ByteFiller byteFiller) {
        List<HashCode> hashCodes = new ArrayList<>();
        mackAddresses.forEach(mackAddress -> {
            crc32.reset();
            crc32.update(mackAddress.getAddress(), 0, mackAddress.getAddress().length);
            hashCodes.add(new BytesHashCode(crc32.getValue(), byteFiller));
        });
        return hashCodes;
    }
}
