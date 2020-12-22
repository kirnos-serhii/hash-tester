package com.khpi.demo.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CutType {
    CUT16(16), CUT32(32);

    private final int bits;
}
