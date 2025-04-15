package io.projects.URLShortnerAPI.service;

import io.projects.URLShortnerAPI.dao.URLShortnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class URLShortnerService {

    private final URLShortnerRepository urlShortnerRepository;

    public URLShortnerService(URLShortnerRepository urlShortnerRepository) {
        this.urlShortnerRepository = urlShortnerRepository;
    }



}
