package br.ifsc.edu.fln.iotprojectapi.controllers;

import br.ifsc.edu.fln.iotprojectapi.models.Location;
import br.ifsc.edu.fln.iotprojectapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        //return the http status as ok(code 200) and sends all locations in the body
        return ResponseEntity.status(HttpStatus.OK).body(locationService.findAll());
    }



}
