package com.codegym.customermanagerpaging.service;


import com.codegym.customermanagerpaging.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
