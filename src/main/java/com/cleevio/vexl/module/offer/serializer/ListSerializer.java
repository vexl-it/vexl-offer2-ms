package com.cleevio.vexl.module.offer.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ListSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String[] split = value.split(";");
        gen.writeStartArray();
        for (String s: split) {
            gen.writeString(s);
        }
        gen.writeEndArray();
    }
}
