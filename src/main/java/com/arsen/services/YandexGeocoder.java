package com.arsen.services;

import com.arsen.models.GeocoderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class YandexGeocoder {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public YandexGeocoder(@Value("${yandex.api.key}") String apiKey, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public Map<String, String> geocode(String address) {
        String url = "https://geocode-maps.yandex.ru/1.x/?apikey=" + apiKey + "&format=json&geocode=" + address;
        GeocoderResponse response = restTemplate.getForObject(url, GeocoderResponse.class);
        if (response != null) {
            GeocoderResponse.GeoObject geoObject = response.getResponse().getGeoObjectCollection().getFeatureMembers()[0].getGeoObject();
            String coordinates = geoObject.getPoint().getPos();
            String formattedAddress = geoObject.getMetaDataProperty().getGeocoderMetaData().getText();
            Map<String, String> result = new HashMap<>();
            result.put("coordinates", coordinates);
            result.put("address", formattedAddress);
            log.info("Успешное получение данных с геокодера!");
            return result;
        }
        log.warn("Ошибка получения данных с геокодера!");
        return null;
    }
}

