package com.travix.medusa.busyflights.domain.busyflights;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsServiceTest {


    @Autowired
    private BusyFlightsService service;

    @Test
    public void listFlights() {
        List<BusyFlightsResponse> flights = service.listFlights(new BusyFlightsRequest());
        assertThat(flights, hasItems(
                hasProperty("suplier", is(FlightSupplier.CRAZY_AIR.getSupplierName())),
                hasProperty("suplier", is(FlightSupplier.TOUGH_JET.getSupplierName())),
                hasProperty("fare", is(210.5))
        ));
    }
}
