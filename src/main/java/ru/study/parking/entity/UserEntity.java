package ru.study.parking.entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usr")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String email;
    private String userpic;
    private LocalDateTime lastVisit;

    @ElementCollection(fetch = FetchType.EAGER)
    @Cascade(value = {
        org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH, org.hibernate.annotations.CascadeType.REMOVE
            })
    private List<String> cars = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<HistoryParking> historyParking = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public List<HistoryParking> getHistoryParking() {
        return historyParking;
    }

    public void setHistoryParking(List<HistoryParking> historyParking) {
        this.historyParking = historyParking;
    }
}
