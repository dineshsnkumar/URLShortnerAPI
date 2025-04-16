package io.projects.URLShortnerAPI.service;

import io.projects.URLShortnerAPI.dao.URLShortnerRepository;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
