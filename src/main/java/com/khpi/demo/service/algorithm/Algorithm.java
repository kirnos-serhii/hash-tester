package com.khpi.demo.service.algorithm;

import com.khpi.demo.entity.HashCode;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.util.filler.ByteFiller;

import java.util.List;
import java.util.Set;

/**
 * An interface for executing hash code execution on dataset.
 */
public interface Algorithm {

    /**
     * Computes the hash of the set value.
     * @param mackAddresses -
     * @return -
     */
    List<HashCode> execute(Set<MackAddress> mackAddresses, ByteFiller byteFiller);
}
