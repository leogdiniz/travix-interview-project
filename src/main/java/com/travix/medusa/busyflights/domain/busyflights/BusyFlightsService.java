package com.travix.medusa.busyflights.domain.busyflights;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightsService {

    @Autowired
    private ApplicationContext context;

    public List<BusyFlightsResponse> listFlights(BusyFlightsRequest request) {
        Map<String, BusyFlightsAdapter> adapters = context.getBeansOfType(BusyFlightsAdapter.class);
        List<BusyFlightsResponse> flights = new ArrayList<>();
        adapters.values().forEach(a -> flights.addAll(a.getFlights(request)));
        flights.sort(Comparator.comparing(BusyFlightsResponse::getFare));
        return flights;
    }
}
