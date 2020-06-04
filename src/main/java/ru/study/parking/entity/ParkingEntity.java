package ru.study.parking.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "parking")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Integer numberOfPlaces;

    private Integer availablePlaces;

    private Integer occupiedPlaces;

    private Double lon;

    private Double lat;

    private Double price;

    @Column(name = "rating", nullable = false, columnDefinition = "double precision default 0")
    private Double rating;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer numberOfRating;

    @ElementCollection
    @CollectionTable(name = "working_hours",
            joinColumns = {@JoinColumn(name = "working_hours_id", referencedColumnName = "id")})
    private Map<Integer, ArrayList<LocalTime>> workingHours = new HashMap<>();

    @OneToMany(
            cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<HistoryParking> historyParking = new ArrayList<>();

    @ElementCollection()
    private List<String> carNumbers = new ArrayList<>();

    public ParkingEntity() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(Integer availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public List<HistoryParking> getHistoryParking() {
        return historyParking;
    }

    public void setHistoryParking(List<HistoryParking> historyParking) {
        this.historyParking = historyParking;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfRating() {
        return numberOfRating;
    }

    public void setNumberOfRating(Integer numberOfRating) {
        this.numberOfRating = numberOfRating;
    }
}
