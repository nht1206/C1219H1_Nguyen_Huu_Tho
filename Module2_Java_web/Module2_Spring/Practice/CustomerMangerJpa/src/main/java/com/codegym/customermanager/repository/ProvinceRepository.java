package com.codegym.customermanager.repository;

import com.codegym.customermanager.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
