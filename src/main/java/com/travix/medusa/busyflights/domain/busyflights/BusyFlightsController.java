package com.travix.medusa.busyflights.domain.busyflights;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/flight")
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<BusyFlightsResponse>> listFlights(@Valid BusyFlightsRequest request){
        return ResponseEntity.ok(service.listFlights(request));
    }

}
