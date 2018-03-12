package com.travix.medusa.busyflights.domain.crazyair;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CrazyAirResponse {

    private String airline;
    private double price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    //Changed from string to LocalDateTime to meet the specifications
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

}
