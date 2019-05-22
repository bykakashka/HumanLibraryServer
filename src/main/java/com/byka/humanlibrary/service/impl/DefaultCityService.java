package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.entity.City;
import com.byka.humanlibrary.repository.CityRepository;
import com.byka.humanlibrary.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DefaultCityService implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        cities.sort(Comparator.comparing(City::getNameRu));
        return cities;
    }
}
