package io.projects.URLShortnerAPI.controllers;

import io.projects.URLShortnerAPI.entities.URLShortnerRequest;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import io.projects.URLShortnerAPI.service.URLShortnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shorten")
public class URLShortnerController {

    private final URLShortnerService urlShortnerService;

    public URLShortnerController(URLShortnerService urlShortnerService) {
        this.urlShortnerService = urlShortnerService;
    }

    @PostMapping
    public URLShortnerResponse shortenURL(@RequestBody URLShortnerRequest url){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setUrl(url.getUrl());
        return response;
    }
    @GetMapping("/{shortCode}")
    public Optional<URLShortnerResponse> originalURL(@PathVariable String shortCode){
        return urlShortnerService.getURLByShortCode(shortCode);
    }

    @PutMapping("/{shortCode}")
    public URLShortnerResponse shortenUpdateURL(@PathVariable String shortCode, @RequestBody URLShortnerRequest url){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setShortCode(shortCode);
        response.setUrl(url.getUrl());
        return response;
    }

    @DeleteMapping("/{shortCode}")
    public void deleteMapping(@PathVariable String url){

    }

    @GetMapping("/{shortCode}/stats")
    public URLShortnerResponse stats(@PathVariable String shortCode){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setShortCode(shortCode);
        return response;
    }

}
