package ru.study.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.study.parking.converters.Converter;
import ru.study.parking.dao.interfaces.ParkingService;
import ru.study.parking.entity.ParkingEntity;
import ru.study.parking.transfers.ParkingTransfer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("parking")
public class ParkingController {

    private ParkingService parkingService;

    private Converter converter;


    @Autowired
    public ParkingController(ParkingService parkingService, Converter converter) {
        this.parkingService = parkingService;
        this.converter = converter;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllParking() {
        List<ParkingEntity> all = parkingService.findAll();
        return ResponseEntity.ok(converter.convertParkingToTransfer(all));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getParkingById(@PathVariable Long id) {
        return ResponseEntity.ok(converter.convertParkingToTransfer(parkingService.findById(id)));
    }

    @GetMapping(value = "/open", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOpenParking(){
        List<ParkingEntity> parkings = parkingService.findOpenParking(LocalDateTime.now());
        return ResponseEntity.ok(converter.convertParkingToTransfer(parkings));
    }

    @PostMapping
    public void addParking(@RequestBody ParkingTransfer parking) {
        parkingService.addParking(converter.convertParkingToEntity(parking));
    }

    @PostMapping("test")
    public void add() {
        ParkingEntity parking = new ParkingEntity();

        parking.setAddress("Центральная улица 23");
        parking.setNumberOfPlaces(100);
        parking.setOccupiedPlaces(0);
        parking.setPrice(500.);

        Map<Integer, ArrayList<LocalTime>> t = new HashMap<>();
        t.put(1, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(2, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(3, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(4, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(5, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(6, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(7, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));

        parking.setWorkingHours(t);

        parkingService.addParking(parking);
    }

    @PutMapping("/{id}/car")
    public void addCar(@PathVariable Long id, @RequestBody String carNumber) {
        parkingService.addCar(id, carNumber);
    }

    @DeleteMapping("/{id}/car")
    public void deleteCar(@PathVariable Long id, @RequestBody String carNumber) {
        parkingService.removeCar(id, carNumber);
    }
}
