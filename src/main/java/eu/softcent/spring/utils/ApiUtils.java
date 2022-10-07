package eu.softcent.spring.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ApiUtils {
  public static String toJson(Object object) {
    final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    try {
      return ow.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      return "json parsing failed";
    }
  }
}
