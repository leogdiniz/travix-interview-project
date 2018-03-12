package com.travix.medusa.busyflights.domain.toughjet;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.busyflights.FlightSupplier;

@Component
public class ToughJetResponseConverter implements Converter<ToughJetResponse, BusyFlightsResponse> {

    @Override
    public BusyFlightsResponse convert(ToughJetResponse toughJetResponse) {
        return BusyFlightsResponse.builder()
                .airline(toughJetResponse.getCarrier())
                .arrivalDate(ZonedDateTime.ofInstant(toughJetResponse.getInboundDateTime(), ZoneOffset.UTC))
                .departureDate(ZonedDateTime.ofInstant(toughJetResponse.getOutboundDateTime(), ZoneOffset.UTC))
                .airline(toughJetResponse.getCarrier())
                .departureAirportCode(toughJetResponse.getDepartureAirportName())
                .destinationAirportCode(toughJetResponse.getArrivalAirportName())
                .fare(calFare(toughJetResponse))
                .suplier(FlightSupplier.TOUGH_JET.getSupplierName())
                .build();
    }

    private double calFare(ToughJetResponse toughJetResponse){
        double priceWithDiscount = toughJetResponse.getBasePrice() * (100 - toughJetResponse.getDiscount()) / 100;
        return priceWithDiscount + toughJetResponse.getTax();
    }
}
