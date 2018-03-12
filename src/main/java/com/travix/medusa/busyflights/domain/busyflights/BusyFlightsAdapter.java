package com.travix.medusa.busyflights.domain.busyflights;

import java.util.List;

public interface BusyFlightsAdapter {

    List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest);

}
