package ru.study.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.study.parking.converters.Converter;
import ru.study.parking.dao.interfaces.ParkingService;
import ru.study.parking.dao.interfaces.UserService;
import ru.study.parking.entity.HistoryParking;
import ru.study.parking.entity.ParkingEntity;
import ru.study.parking.entity.UserEntity;
import ru.study.parking.transfers.ParkingTransfer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/v1/parking")
public class ParkingController {

    private ParkingService parkingService;
    private UserService userService;

    private Converter converter;


    @Autowired
    public ParkingController(ParkingService parkingService, UserService userService, Converter converter) {
        this.parkingService = parkingService;
        this.userService = userService;
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
        parking.setAddress("27 Линия, 16, Санкт-Петербург");
        parking.setNumberOfPlaces(100);
        parking.setOccupiedPlaces(0);
        parking.setPrice(0.);
        parking.setLat(59.933063);
        parking.setLon(30.254244);
        Map<Integer, ArrayList<LocalTime>> t = new HashMap<>();
        t.put(1, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(2, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(3, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(4, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(5, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(6, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t.put(7, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        parking.setWorkingHours(t);

        ParkingEntity parking1 = new ParkingEntity();
        parking1.setAddress("Парковка Исакиевская Площадь");
        parking1.setNumberOfPlaces(200);
        parking1.setOccupiedPlaces(0);
        parking1.setPrice(0.);
        parking1.setLat(59.931911);
        parking1.setLon(30.308596);
        Map<Integer, ArrayList<LocalTime>> t1 = new HashMap<>();
        t1.put(1, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(2, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(3, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(4, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(5, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(6, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        t1.put(7, new ArrayList<>(Arrays.asList(LocalTime.of(0, 0), LocalTime.of(23, 59, 59, 999999999))));
        parking1.setWorkingHours(t1);

        ParkingEntity parking2 = new ParkingEntity();
        parking2.setAddress("Лиговский пр., 50 к. 3, Санкт-Петербург, 191040");
        parking2.setNumberOfPlaces(600);
        parking2.setOccupiedPlaces(0);
        parking2.setPrice(150.);
        parking2.setLat(59.927307);
        parking2.setLon(30.360214);
        Map<Integer, ArrayList<LocalTime>> t2 = new HashMap<>();
        t2.put(1, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(2, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(3, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(4, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(5, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(6, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        t2.put(7, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(23, 59, 59, 999999999))));
        parking2.setWorkingHours(t2);

        ParkingEntity parking3 = new ParkingEntity();
        parking3.setAddress("Парковка Планета Нептун");
        parking3.setNumberOfPlaces(300);
        parking3.setOccupiedPlaces(0);
        parking3.setPrice(100.);
        parking3.setLat(59.918751);
        parking3.setLon(30.338213);
        Map<Integer, ArrayList<LocalTime>> t3 = new HashMap<>();
        t3.put(1, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(2, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(3, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(4, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(5, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(6, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        t3.put(7, new ArrayList<>(Arrays.asList(LocalTime.of(10, 0), LocalTime.of(22, 0, 0, 0))));
        parking3.setWorkingHours(t3);

        parkingService.addParking(parking);
        parkingService.addParking(parking1);
        parkingService.addParking(parking2);
        parkingService.addParking(parking3);
    }


    //C авторизацией
    /*@PutMapping("/{id}/car")
    public void addCar(@PathVariable(name = "id") Long parkingId, @RequestBody String carNumber, @AuthenticationPrincipal UserEntity user) {
        ParkingEntity parking = parkingService.findById(parkingId);
        parking.getCarNumbers().add(carNumber);
        parking.setOccupiedPlaces(parking.getOccupiedPlaces() + 1);
        parkingService.addCar(parking);
        user.getHistoryParking().add(new HistoryParking(carNumber, parking, LocalDateTime.now()));
        userService.update(user);
    }*/

    @PutMapping("/{id}/car")
    public void addCar(@PathVariable(name = "id") Long parkingId, @RequestBody String carNumber) {
        ParkingEntity parking = parkingService.findById(parkingId);
        parking.getCarNumbers().add(carNumber);
        parking.setOccupiedPlaces(parking.getOccupiedPlaces() + 1);
        HistoryParking historyParking = new HistoryParking(carNumber, parking, LocalDateTime.now());
        parking.getHistoryParking().add(historyParking);
        parkingService.addCar(parking);
    }

    @DeleteMapping("/{id}/car")
    public void deleteCar(@PathVariable Long id, @RequestBody String carNumber) {
        parkingService.removeCar(id, carNumber);
    }
}
