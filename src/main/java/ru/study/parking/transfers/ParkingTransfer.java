package ru.study.parking.transfers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingTransfer {

    private Long id;

    private String address;

    private String name;

    private Integer numberOfPlaces;

    private Integer occupiedPlaces;

    private Integer availablePlaces;

    private Double price;

    private Map<Integer, ArrayList<LocalTime>> workingHours = new HashMap<>();

    private List<String> carNumbers = new ArrayList<>();

    public ParkingTransfer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Integer getOccupiedPlaces() {
        return occupiedPlaces;
    }

    public void setOccupiedPlaces(Integer occupiedPlaces) {
        this.occupiedPlaces = occupiedPlaces;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Map<Integer, ArrayList<LocalTime>> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Map<Integer, ArrayList<LocalTime>> workingHours) {
        this.workingHours = workingHours;
    }

    public List<String> getCarNumbers() {
        return carNumbers;
    }

    public void setCarNumbers(List<String> carNumbers) {
        this.carNumbers = carNumbers;
    }

    public Integer getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(Integer availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
