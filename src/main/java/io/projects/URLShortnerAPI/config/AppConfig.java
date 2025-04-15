package io.projects.URLShortnerAPI.config;

import io.projects.URLShortnerAPI.dao.URLShortnerRepository;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {

    private final URLShortnerRepository urlShortnerRepository;

    public AppConfig(URLShortnerRepository urlShortnerRepository) {
        this.urlShortnerRepository = urlShortnerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (urlShortnerRepository.count() == 0){
            urlShortnerRepository.saveAll(List.of( new URLShortnerResponse()));
        }
    }
}
