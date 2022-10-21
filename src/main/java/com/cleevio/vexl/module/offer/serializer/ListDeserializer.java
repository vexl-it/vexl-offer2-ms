package com.cleevio.vexl.module.offer.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import javax.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class ListDeserializer extends JsonDeserializer<String> {

    @Override
    @Nullable
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            List<String> list = new ArrayList<>();
            jsonParser.nextToken();

            while (jsonParser.hasCurrentToken() && jsonParser.currentToken() != JsonToken.END_ARRAY) {
                list.add(jsonParser.getValueAsString());
                jsonParser.nextToken();
            }
            return String.join(";", list);
        }
        return null;
    }


}
