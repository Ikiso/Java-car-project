package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CarSearchRepository extends ElasticsearchRepository<Car, Long> {
    Page<Car> searchByBrand(String text, Pageable pageable);
}
