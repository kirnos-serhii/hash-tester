package com.khpi.demo.service.algorithm.impl;

import com.khpi.demo.entity.BytesHashCode;
import com.khpi.demo.entity.HashCode;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.service.algorithm.Algorithm;
import com.khpi.demo.util.filler.ByteFiller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class SHA512Algorithm implements Algorithm {

    private MessageDigest md;

    @Override
    public List<HashCode> execute(Set<MackAddress> mackAddresses, ByteFiller byteFiller) {
        List<HashCode> hashCodes = new ArrayList<>();
        mackAddresses.forEach(mackAddress ->
                hashCodes.add(new BytesHashCode(md.digest(mackAddress.getAddress()), byteFiller)));
        return hashCodes;
    }
}
