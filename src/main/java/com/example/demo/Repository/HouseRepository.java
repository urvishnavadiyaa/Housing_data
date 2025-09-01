package com.example.demo.Repository;

import com.example.demo.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    @Query(value = "SELECT AVG(sale_Price) FROM house", nativeQuery = true)
    int fndAvg();

    @Query(value = "SELECT location, AVG(sale_price) FROM house GROUP BY location", nativeQuery = true)
    Object[] fndAvgLocation();

    @Query(value = "SELECT MAX(sale_price) FROM house", nativeQuery = true)
    int fndMax();

    @Query(value = "SELECT MIN(sale_price) FROM house", nativeQuery = true)
    int fndMin();

    @Query(value = "SELECT AVG(sale_price) FROM house WHERE location = ?1", nativeQuery = true)
    int getAvg(String location);

}
