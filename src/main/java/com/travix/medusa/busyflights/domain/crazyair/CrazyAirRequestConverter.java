package com.travix.medusa.busyflights.domain.crazyair;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

@Component
public class CrazyAirRequestConverter implements Converter<BusyFlightsRequest, CrazyAirRequest> {
    @Override
    public CrazyAirRequest convert(BusyFlightsRequest request) {
        return CrazyAirRequest.builder()
                .departureDate(request.getDepartureDate())
                .destination(request.getDestination())
                .origin(request.getOrigin())
                .passengerCount(request.getNumberOfPassengers())
                .returnDate(request.getReturnDate())
                .build();
    }
}
