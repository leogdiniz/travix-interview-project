package com.travix.medusa.busyflights.domain.toughjet;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ToughJetRequest {

    private String from;
    private String to;
    private LocalDate outboundDate;
    private LocalDate inboundDate;
    private int numberOfAdults;

}
