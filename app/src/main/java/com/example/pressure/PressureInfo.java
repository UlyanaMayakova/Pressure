package com.example.pressure;

import java.util.Date;

public class PressureInfo {
    private int higherPressure, lowerPressure, pulse;
    private boolean tahikardia;
    private Date time;

    public PressureInfo(int higherPressure, int lowerPressure, int pulse, boolean tahikardia, Date time) {
        this.higherPressure = higherPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tahikardia = tahikardia;
        this.time = time;
    }
}