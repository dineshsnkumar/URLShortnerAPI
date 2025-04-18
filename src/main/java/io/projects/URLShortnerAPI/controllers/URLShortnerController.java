package io.projects.URLShortnerAPI.controllers;

import io.projects.URLShortnerAPI.entities.URLShortnerRequest;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import io.projects.URLShortnerAPI.service.URLShortnerService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public URLShortnerResponse shortenURL(@RequestBody URLShortnerRequest url){
        return urlShortnerService.saveUrl(url);
    }

    @GetMapping("/{shortCode}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<URLShortnerResponse> originalURL(@PathVariable String shortCode){
        return urlShortnerService.getURLByShortCode(shortCode);
    }

    @PutMapping("/{shortCode}")
    @ResponseStatus(code = HttpStatus.OK)
    public URLShortnerResponse shortenUpdateURL(@PathVariable String shortCode, @RequestBody URLShortnerRequest url){
        return urlShortnerService.updateUrl(url, shortCode);
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
