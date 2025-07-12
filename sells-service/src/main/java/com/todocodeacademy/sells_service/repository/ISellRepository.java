package com.todocodeacademy.sells_service.repository;

import com.todocodeacademy.sells_service.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellRepository extends JpaRepository<Sell, Long> {

}
