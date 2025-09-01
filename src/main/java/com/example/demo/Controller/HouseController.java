package com.example.demo.Controller;

import com.example.demo.DTO.LocationAverageDTO;
import com.example.demo.Model.House;
import com.example.demo.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    HouseService houseservice;

    @PostMapping("/save-data")
    public ResponseEntity<?> saveAllHouses(@RequestBody List<House> houses) {
        try {
            List<House> saved = houseservice.saveAll(houses);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @GetMapping("/average")
    public int findAvg() {
        return houseservice.findAverage();
    }

    @GetMapping("/average-location")
    public ResponseEntity<?> findAvgLocation() {
        return houseservice.findAverageLocation();
    }

    @GetMapping("/max")
    public int findMax() {
        return houseservice.findMax();
    }

    @GetMapping("/min")
    public int findMin() {
        return houseservice.findMin();
    }

    @GetMapping("/avg-by-loc/{location}")
    public int getAverage(@PathVariable String location) {
        return houseservice.getAverage(location);
    }


}
