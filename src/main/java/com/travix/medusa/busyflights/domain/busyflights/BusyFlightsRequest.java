package com.travix.medusa.busyflights.domain.busyflights;

import java.time.LocalDate;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusyFlightsRequest {

    @Length(max = 3, min = 3)
    private String origin;
    @Length(max = 3, min = 3)
    private String destination;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;
    @Max(4)
    private int numberOfPassengers;

}
