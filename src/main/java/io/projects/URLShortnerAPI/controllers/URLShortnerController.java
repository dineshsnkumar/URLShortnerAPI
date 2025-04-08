package io.projects.URLShortnerAPI.controllers;

import io.projects.URLShortnerAPI.dao.URLShortnerRequest;
import io.projects.URLShortnerAPI.dao.URLShortnerResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shorten")
public class URLShortnerController {

    @PostMapping
    public URLShortnerResponse shortenURL(@RequestBody URLShortnerRequest url){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setUrl(url.getUrl());
        return response;
    }
    @GetMapping("/{shortCode}")
    public URLShortnerResponse originalURL(@PathVariable String shortCode){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setShortCode(shortCode);
        return response;
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
