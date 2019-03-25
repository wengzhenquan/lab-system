package com.wzq.labsystem.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

/**
 * Instant序列化
 */
public class InstantJacksonDeserialize extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        Long aLong = Long.valueOf(text);
        Instant res = Instant.ofEpochMilli(aLong);
        return res;
    }
}