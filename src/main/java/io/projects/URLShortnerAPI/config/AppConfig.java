package io.projects.URLShortnerAPI.config;

import io.projects.URLShortnerAPI.dao.URLShortnerRepository;
import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {

    private final URLShortnerRepository urlShortnerRepository;

    public AppConfig(URLShortnerRepository urlShortnerRepository) {
        this.urlShortnerRepository = urlShortnerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        URLShortnerResponse response1 = new URLShortnerResponse("http://urlshortner.io/asdasdasdasdasdsdds", "abcd", new GregorianCalendar(2025, Calendar.APRIL, 16).getTime(), new Date(), 0);
        URLShortnerResponse response2 = new URLShortnerResponse("http://urlshortner.io/asdasdasdasdasdsdds", "efgh", new GregorianCalendar(2025, Calendar.APRIL, 16).getTime(), new Date(), 0);
        urlShortnerRepository.saveAll(List.of(response1, response2)).forEach(System.out::println);
        System.out.println("-- Data creation complete -----");
    }
}
