package com.arsen.controllers;

import com.arsen.services.YandexGeocoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class GeocoderController {
    private final YandexGeocoder yandexGeocoder;

    @Autowired
    public GeocoderController(YandexGeocoder yandexGeocoder) {
        this.yandexGeocoder = yandexGeocoder;
    }

    @GetMapping("/geocode")
    public Map<String, String> geocode(@RequestParam String address) {
        log.info("Запуск роута!");
        return yandexGeocoder.geocode(address);
    }
}

