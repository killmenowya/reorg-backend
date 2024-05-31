package com.reorg.course_details.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Arrays;

public class WorkloadDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if (node.isArray()) {
            int[] workloadArray = new int[node.size()];
            for (int i = 0; i < node.size(); i++) {
                workloadArray[i] = node.get(i).asInt();
            }
            return Arrays.toString(workloadArray);
        } else {
            return node.asText();
        }
    }
}