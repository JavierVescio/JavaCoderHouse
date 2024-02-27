package com.example.demo.services;

import com.example.demo.models.WorldClock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FechaRestApi {
    public static LocalDateTime getFecha() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        WorldClock worldClock = restTemplate.getForObject(url, WorldClock.class);
        if (worldClock.getCurrentDateTime() == null){
            return LocalDateTime.now();
        }
        ZonedDateTime zdt = ZonedDateTime.parse(worldClock.getCurrentDateTime());
        return zdt.toLocalDateTime();
    }
}
