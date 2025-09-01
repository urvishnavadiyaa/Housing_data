package com.example.demo.Service;

import com.example.demo.DTO.LocationAverageDTO;
import com.example.demo.Model.House;
import com.example.demo.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    HouseRepository houserepository;

    public List<House> saveAll(List<House> houses) {
        return houserepository.saveAll(houses);
    }

    public int findAverage() {
        return houserepository.fndAvg();
    }

    public ResponseEntity<?> findAverageLocation() {
        Object[] results=  houserepository.fndAvgLocation();
        try {
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("server error :"+ e.getMessage());
        }
    }

    public int findMax() {
        return houserepository.fndMax();
    }

    public int findMin() {
        return houserepository.fndMin();
    }

    public int getAverage(String location) {
        return houserepository.getAvg(location);
    }
}
