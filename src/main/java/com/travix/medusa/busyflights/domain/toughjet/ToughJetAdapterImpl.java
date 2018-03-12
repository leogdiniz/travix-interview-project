package com.travix.medusa.busyflights.domain.toughjet;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsAdapter;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Component
public class ToughJetAdapterImpl implements BusyFlightsAdapter {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ToughJetApiFacade toughJetAPI;

    @Override
    public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) {
        ToughJetRequest request = conversionService.convert(busyFlightsRequest, ToughJetRequest.class);
        List<ToughJetResponse> flights = toughJetAPI.listFlights(request);
        return flights.stream()
                .map(f -> conversionService.convert(f, BusyFlightsResponse.class))
                .collect(Collectors.toList());
    }

}
