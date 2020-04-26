package ru.study.parking.dao.interfaces;

import org.springframework.stereotype.Service;
import ru.study.parking.entity.ParkingEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public interface ParkingService {

    public List<ParkingEntity> findAll();
    public ParkingEntity findById(Long id);
    public void addParking(ParkingEntity parking);
    public List<ParkingEntity> findOpenParking(LocalDateTime time);
    public void addCar(Long parkingId,String carNumber);
    public void removeCar(Long parkingId, String carNumber);

}
