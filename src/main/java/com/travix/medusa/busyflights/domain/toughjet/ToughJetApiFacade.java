package com.travix.medusa.busyflights.domain.toughjet;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ToughJetApiFacade {

    public List<ToughJetResponse> listFlights(ToughJetRequest request) {
        return Arrays.asList(
                ToughJetResponse.builder()
                .arrivalAirportName("CNF")
                .departureAirportName("NSW")
                .basePrice(200.00)
                .tax(20.50)
                .discount(5.0)
                .inboundDateTime(Instant.now())
                .outboundDateTime(Instant.now())
                .carrier("TAM")
                .build(),
                ToughJetResponse.builder()
                        .arrivalAirportName("CAF")
                        .departureAirportName("EST")
                        .basePrice(400.00)
                        .tax(50.50)
                        .discount(15.0)
                        .inboundDateTime(Instant.now())
                        .outboundDateTime(Instant.now())
                        .carrier("EMIRATES")
                        .build(),
                ToughJetResponse.builder()
                        .arrivalAirportName("CNF")
                        .departureAirportName("SYD")
                        .basePrice(400.00)
                        .tax(50.35)
                        .discount(50.0)
                        .inboundDateTime(Instant.now())
                        .outboundDateTime(Instant.now())
                        .carrier("ETIHAD")
                        .build()
        );
    }
}
