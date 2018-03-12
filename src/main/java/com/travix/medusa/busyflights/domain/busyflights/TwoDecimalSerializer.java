package com.travix.medusa.busyflights.domain.busyflights;

import java.io.IOException;
import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class TwoDecimalSerializer extends JsonSerializer<Double> {

    private DecimalFormat format = new DecimalFormat("#.00");

    @Override
    public void serialize(Double v, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(format.format(v));
    }
}
