package com.travix.medusa.busyflights.domain.toughjet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public class ToughJetResponseConverterTest {

    private ToughJetResponseConverter converter;


    @Before
    public void setup(){
        converter = new ToughJetResponseConverter();
    }

    @Test
    public void verifyFareCalculation(){
        BusyFlightsResponse reponse = converter.convert(ToughJetResponse.builder()
                .basePrice(200)
                .tax(50)
                .discount(50)
                .inboundDateTime(Instant.now())
                .outboundDateTime(Instant.now())
                .build());

        assertThat(reponse.getFare(), is(150.0));
    }
}
