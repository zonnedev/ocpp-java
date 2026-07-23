package io.github.zonnedev.ocpp.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class OcppObjectMapperFactory {
  private OcppObjectMapperFactory() {
  }
  public static ObjectMapper create() {
    return JsonMapper.builder()
      .addModule(new JavaTimeModule())
      .disable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)
      .disable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)
      .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .enable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)
      .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .serializationInclusion(
        com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
      )
      .build();
  }
}
