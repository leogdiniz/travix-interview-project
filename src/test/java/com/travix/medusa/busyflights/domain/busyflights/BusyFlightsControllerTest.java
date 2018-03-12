package com.travix.medusa.busyflights.domain.busyflights;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirAdapterImpl;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetAdapterImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BusyFlightsController.class)
public class BusyFlightsControllerTest {

    private String url = "/v1/flight/list";

    @Autowired
    protected MockMvc mvc;

    @SpyBean
    private BusyFlightsService service;

    @MockBean
    private CrazyAirAdapterImpl crazyAirAdapter;

    @MockBean
    private ToughJetAdapterImpl toughJetAdapter;

    @Test
    public void listFlights() throws Exception {

        when(crazyAirAdapter.getFlights(any()))
                .thenReturn(Collections.singletonList(BusyFlightsResponse.builder()
                .airline("Emirates")
                .fare(10.155)
                .arrivalDate(ZonedDateTime.of(2018, 3, 11, 23, 45, 18, 0, ZoneOffset.UTC))
                .suplier(FlightSupplier.CRAZY_AIR.getSupplierName())
                .build()));
        when(toughJetAdapter.getFlights(any()))
                .thenReturn(Collections.singletonList(BusyFlightsResponse.builder()
                        .airline("LATAM")
                        .fare(11.135)
                        .arrivalDate(ZonedDateTime.now())
                        .suplier(FlightSupplier.TOUGH_JET.getSupplierName())
                        .build()));

        mvc.perform(get(url + "?origin=CNF&departureDate=2018-12-12").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].airline", is("Emirates")))
                .andExpect(jsonPath("$.[0].fare", is("10.15")))
                .andExpect(jsonPath("$.[0].arrivalDate", is("2018-03-11T23:45:18Z")))
                .andExpect(jsonPath("$.[1].airline", is("LATAM")))
                .andExpect(jsonPath("$.[1].fare", is("11.13")));

        ArgumentCaptor<BusyFlightsRequest> argument = ArgumentCaptor.forClass(BusyFlightsRequest.class);
        verify(service).listFlights(argument.capture());
        assertEquals(argument.getValue().getOrigin(), "CNF");
        assertEquals(argument.getValue().getDepartureDate(), LocalDate.of(2018,12,12));
    }

    @Test
    public void expectBadRequestLongOrigin() throws Exception {

        mvc.perform(get(url + "?origin=CNFA").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void expectBadRequestTooManyPassengers() throws Exception {

        mvc.perform(get(url + "?numberOfPassengers=5").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }
}
