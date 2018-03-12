package com.travix.medusa.busyflights.domain.busyflights;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BusyFlightsResponse {

    private String airline;
    private String suplier;
    @JsonSerialize(using = TwoDecimalSerializer.class)
    private Double fare;
    private String departureAirportCode;
    private String destinationAirportCode;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private ZonedDateTime departureDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private ZonedDateTime arrivalDate;

}
