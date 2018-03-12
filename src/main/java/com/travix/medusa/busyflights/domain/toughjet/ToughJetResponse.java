package com.travix.medusa.busyflights.domain.toughjet;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ToughJetResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    //Changed from string to Instant to meet the specifications
    private Instant outboundDateTime;
    private Instant inboundDateTime;

}
