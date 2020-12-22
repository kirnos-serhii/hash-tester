package com.khpi.demo.service.algorithm;

import com.khpi.demo.entity.enumeration.AlgorithmType;
import com.khpi.demo.service.algorithm.impl.CRC16Algorithm;
import com.khpi.demo.service.algorithm.impl.CRC32Algorithm;
import com.khpi.demo.service.algorithm.impl.SHA512Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.khpi.demo.entity.enumeration.AlgorithmType.CRC16;
import static com.khpi.demo.entity.enumeration.AlgorithmType.CRC32;
import static com.khpi.demo.entity.enumeration.AlgorithmType.SHA512;

@Component
public class AlgorithmContainer {

    private final Map<AlgorithmType, Algorithm> algorithmsMap = new HashMap<>();

    @Autowired
    public AlgorithmContainer(
            CRC16Algorithm crc16Algorithm,
            CRC32Algorithm crc32Algorithm,
            SHA512Algorithm sha512Algorithm) {
        algorithmsMap.put(CRC16, crc16Algorithm);
        algorithmsMap.put(CRC32, crc32Algorithm);
        algorithmsMap.put(SHA512, sha512Algorithm);
    }

    public Algorithm get(AlgorithmType key) {
        return algorithmsMap.get(key);
    }
}
