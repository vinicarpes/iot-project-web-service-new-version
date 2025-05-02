package br.ifsc.edu.fln.iotprojectapi.controllers;

import br.ifsc.edu.fln.iotprojectapi.dtos.LocationDTO;
import br.ifsc.edu.fln.iotprojectapi.models.Location;
import br.ifsc.edu.fln.iotprojectapi.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id){
        if(locationService.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Location Not Found");
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid LocationDTO locationDTO){
        if(locationService.existsByLatitude(locationDTO.getLatitude())
                && locationService.existsByLongitude(locationDTO.getLongitude())){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("WARN: There is already a location with the same latitude/longitude and longitude");
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location, "id"); //metodo que copia as propriedades de uma classe para outra e ignora o id

        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(location));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,
                                    @RequestBody @Valid LocationDTO locationDTO){
        if(locationService.findById(id).isPresent()){
            Location location = locationService.findById(id).get();
            BeanUtils.copyProperties(locationDTO, location, "id");
            return ResponseEntity.status(HttpStatus.OK).body(locationService.save(location));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Location not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        if(locationService.findById(id).isPresent()){
            Location location = locationService.findById(id).get();
            locationService.delete(location);
            return ResponseEntity.status(HttpStatus.OK).body("Location deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Location not found");
    }
}
