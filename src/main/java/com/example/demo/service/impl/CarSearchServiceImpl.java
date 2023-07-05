package com.example.demo.service.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.example.demo.dto.CarDto;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.service.CarSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQuery;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CarSearchServiceImpl implements CarSearch {

    private final CarMapper carMapper;
    private final ElasticsearchOperations elasticsearchOperations;

    public List<CarDto> searchCars(String query) {
        Query queryBuilder = QueryBuilders.multiMatchQuery(query)
                .field("brand")
                .field("model")
                .field("fuel")
                .field("quantity");

        IndexCoordinates indexCoordinates = IndexCoordinates.of("cars");

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<Car> searchHits = elasticsearchOperations.search(searchQuery, Car.class, indexCoordinates);
        List<Car> cars = searchHits.getSearchHits().stream()
                .map(SearchHit::getContent).toList();

        return carMapper.listCarToListCarDto(cars);
    }
}
