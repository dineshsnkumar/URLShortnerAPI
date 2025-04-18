package io.projects.URLShortnerAPI.service;

import io.projects.URLShortnerAPI.dao.URLShortnerRepository;
import io.projects.URLShortnerAPI.entities.URLShortnerRequest;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class URLShortnerService {

    private final URLShortnerRepository urlShortnerRepository;

    public URLShortnerService(URLShortnerRepository urlShortnerRepository) {
        this.urlShortnerRepository = urlShortnerRepository;
    }

    public List<URLShortnerResponse> getAll(){
        return urlShortnerRepository.findAll();
    }

    public Optional<URLShortnerResponse> getURLByShortCode(String shortCode){
        return urlShortnerRepository.findById(shortCode);
    }

    public URLShortnerResponse saveUrl(URLShortnerRequest url){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setUrl(url.getUrl());
        response.setShortCode("qwer");
        response.setCreatedAt(new GregorianCalendar().getTime());
        return urlShortnerRepository.save(response);
    }

    public URLShortnerResponse updateUrl(URLShortnerRequest url, String shortCode){
        URLShortnerResponse response = new URLShortnerResponse();
        response.setUrl(url.getUrl());
        response.setShortCode(shortCode);
        response.setUpdatedAt(new GregorianCalendar().getTime());
        return urlShortnerRepository.save(response);
    }

    public void deleteUrl(String shortCode){
        List<URLShortnerResponse> responseList  = urlShortnerRepository.findAll();
        for (URLShortnerResponse urlShortnerResponse : responseList){
            if (urlShortnerResponse.getShortCode().equals(shortCode)){
                urlShortnerRepository.delete(urlShortnerResponse);
            }
        }

    }

}
