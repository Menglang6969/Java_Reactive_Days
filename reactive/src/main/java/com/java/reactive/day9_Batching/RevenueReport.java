package com.java.reactive.day9_Batching;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class RevenueReport {
    private LocalDateTime startDate;
    private Map<String,Double> map;

    public RevenueReport( Map<String,Double> map) {
        this.startDate = LocalDateTime.now();
        this.map = map;
    }
}
