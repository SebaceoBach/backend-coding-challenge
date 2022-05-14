package com.example.demo.Repositories;



import java.util.List;

import com.example.demo.Entities.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    

    @Query(
        value = "SELECT * FROM CITY_DETAILS WHERE CITY_DETAILS.name LIKE %:q% OR CITY_DETAILS.long LIKE %:q% OR CITY_DETAILS.lat LIKE %:q%",
        nativeQuery = true
    )
    List<City> search(@Param("q") String q);
    
}
