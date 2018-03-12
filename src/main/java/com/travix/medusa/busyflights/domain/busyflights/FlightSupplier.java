package com.travix.medusa.busyflights.domain.busyflights;

public enum FlightSupplier {

    CRAZY_AIR("CrazyAir"),
    TOUGH_JET("ToughJet");

    private String supplierName;

    FlightSupplier(String name){
        this.supplierName = name;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
