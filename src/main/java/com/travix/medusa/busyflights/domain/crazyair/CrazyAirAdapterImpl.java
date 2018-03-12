package com.travix.medusa.busyflights.domain.crazyair;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Component
public class CrazyAirAdapterImpl implements BusyFlightsAdapter{

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private CrazyAirApiFacade crazyAirApiFacade;

    @Override
    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) {
        CrazyAirRequest request = conversionService.convert(busyFlightsRequest, CrazyAirRequest.class);
        List<CrazyAirResponse> flights = crazyAirApiFacade.listFlights(request);
        return flights.stream()
                .map(f -> conversionService.convert(f, BusyFlightsResponse.class))
                .collect(Collectors.toList());
    }

}
