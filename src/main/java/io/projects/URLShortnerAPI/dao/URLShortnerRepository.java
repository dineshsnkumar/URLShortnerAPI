package io.projects.URLShortnerAPI.dao;

import io.projects.URLShortnerAPI.entities.URLShortnerResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLShortnerRepository extends MongoRepository<URLShortnerResponse, String> {
}
