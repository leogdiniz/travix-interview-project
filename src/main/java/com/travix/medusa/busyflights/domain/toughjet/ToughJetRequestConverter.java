package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

@Component
public class ToughJetRequestConverter implements Converter<BusyFlightsRequest, ToughJetRequest> {

    @Override
    public ToughJetRequest convert(BusyFlightsRequest busyFlightsRequest) {
        return ToughJetRequest.builder()
                .from(busyFlightsRequest.getOrigin())
                .to(busyFlightsRequest.getDestination())
                .outboundDate(busyFlightsRequest.getDepartureDate())
                .inboundDate(busyFlightsRequest.getReturnDate())
                .numberOfAdults(busyFlightsRequest.getNumberOfPassengers())
                .build();
    }
}
