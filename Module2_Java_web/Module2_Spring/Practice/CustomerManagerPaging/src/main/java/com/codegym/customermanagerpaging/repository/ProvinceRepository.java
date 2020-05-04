package com.codegym.customermanagerpaging.repository;


import com.codegym.customermanagerpaging.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
    Optional<Province> findById(Long id);
}
