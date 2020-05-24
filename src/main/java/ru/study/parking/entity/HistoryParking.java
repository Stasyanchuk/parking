package ru.study.parking.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
public class HistoryParking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberCar;

    @OneToOne
    private ParkingEntity parking;

    private LocalDateTime parkingStart;

    public HistoryParking() {
    }

    public HistoryParking(String numberCar, ParkingEntity parking, LocalDateTime parkingStart) {
        this.numberCar = numberCar;
        this.parking = parking;
        this.parkingStart = parkingStart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public ParkingEntity getParking() {
        return parking;
    }

    public void setParking(ParkingEntity parking) {
        this.parking = parking;
    }

    public LocalDateTime getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(LocalDateTime parkingStart) {
        this.parkingStart = parkingStart;
    }
}
