package org.ShcizophreniaInc.in.services;

public interface MeterService {
    void takeReadings();
    void showCurrentReadings();
    void showSpecificMonth(int month);
    void showHistory();
}
