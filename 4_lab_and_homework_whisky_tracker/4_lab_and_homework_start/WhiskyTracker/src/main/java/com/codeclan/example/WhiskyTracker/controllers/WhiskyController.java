package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskiesByYear(
            @RequestParam(name="year", required = false) String year,
            @RequestParam(name="age", required = false) String age,
            @RequestParam(name="distillery", required = false) String distillery,
            @RequestParam(name="region", required = false) String region
    ) {
        if (year != null) {
            int inputYear = Integer.parseInt(year);
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(inputYear), HttpStatus.OK);
        } else if (age != null && distillery != null) {
            int inputAge = Integer.parseInt(age);
            return new ResponseEntity<>(whiskyRepository.findWhiskyByAgeAndDistilleryName(inputAge, distillery), HttpStatus.OK);
        } else if (region != null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }



}
