package com.travix.medusa.busyflights.domain.crazyair;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.busyflights.FlightSupplier;

@Component
public class CrazyAirResponseConverter implements Converter<CrazyAirResponse, BusyFlightsResponse> {

    @Override
    public BusyFlightsResponse convert(CrazyAirResponse crazyAirResponse) {
        return BusyFlightsResponse.builder()
                .destinationAirportCode(crazyAirResponse.getDestinationAirportCode())
                .departureAirportCode(crazyAirResponse.getDepartureAirportCode())
                .airline(crazyAirResponse.getAirline())
                .arrivalDate(ZonedDateTime.of(crazyAirResponse.getArrivalDate(), ZoneOffset.UTC))
                .departureDate(ZonedDateTime.of(crazyAirResponse.getDepartureDate(), ZoneOffset.UTC))
                .fare(crazyAirResponse.getPrice())
                .suplier(FlightSupplier.CRAZY_AIR.getSupplierName())
                .build();
    }
}
