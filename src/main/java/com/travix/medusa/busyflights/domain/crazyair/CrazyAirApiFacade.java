package com.travix.medusa.busyflights.domain.crazyair;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CrazyAirApiFacade {

    public List<CrazyAirResponse> listFlights(CrazyAirRequest request) {
        return Arrays.asList(
                CrazyAirResponse.builder()
                .destinationAirportCode("CNF")
                .departureAirportCode("NSW")
                .price(200.00)
                .arrivalDate(LocalDateTime.now())
                .departureDate(LocalDateTime.now())
                .airline("TAM")
                .cabinclass("E")
                .build(),
                CrazyAirResponse.builder()
                        .destinationAirportCode("CAF")
                        .departureAirportCode("EST")
                        .price(230.00)
                        .arrivalDate(LocalDateTime.now())
                        .departureDate(LocalDateTime.now())
                        .airline("EMIRATES")
                        .cabinclass("B")
                        .build()
        );
    }
}
