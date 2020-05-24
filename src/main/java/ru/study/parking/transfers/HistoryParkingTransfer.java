package ru.study.parking.transfers;

import java.time.LocalDateTime;

public class HistoryParkingTransfer {

    private String numberCar;

    private ParkingTransfer parking;

    private LocalDateTime parkingStart;

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public ParkingTransfer getParking() {
        return parking;
    }

    public void setParking(ParkingTransfer parking) {
        this.parking = parking;
    }

    public LocalDateTime getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(LocalDateTime parkingStart) {
        this.parkingStart = parkingStart;
    }
}
