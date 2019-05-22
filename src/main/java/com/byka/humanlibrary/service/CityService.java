package com.byka.humanlibrary.service;

import com.byka.humanlibrary.entity.City;

import java.util.List;

public interface CityService {
    City getById(Long id);
    List<City> getAll();
}
