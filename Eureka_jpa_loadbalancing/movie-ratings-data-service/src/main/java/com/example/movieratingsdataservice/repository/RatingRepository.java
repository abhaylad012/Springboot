package com.example.movieratingsdataservice.repository;

import com.example.movieratingsdataservice.models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, String> {
}
