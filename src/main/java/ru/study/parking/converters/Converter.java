package ru.study.parking.converters;

import org.springframework.stereotype.Component;
import ru.study.parking.entity.ParkingEntity;
import ru.study.parking.transfers.ParkingTransfer;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public List<ParkingTransfer> convertParkingToTransfer(List<ParkingEntity> parking){
        return parking.stream().map(this::convertParkingToTransfer).collect(Collectors.toList());
    }

    public ParkingTransfer convertParkingToTransfer(ParkingEntity parking){
        ParkingTransfer transfer = new ParkingTransfer();
        transfer.setId(parking.getId());
        transfer.setAddress(parking.getAddress());
        transfer.setName(parking.getName());
        transfer.setPrice(parking.getPrice());
        transfer.setCarNumbers(parking.getCarNumbers());
        transfer.setNumberOfPlaces(parking.getNumberOfPlaces());
        transfer.setOccupiedPlaces(parking.getOccupiedPlaces());
        transfer.setAvailablePlaces(parking.getAvailablePlaces());
        transfer.setWorkingHours(parking.getWorkingHours());
        return transfer;
    }

    public List<ParkingEntity> convertParkingToEntity(List<ParkingTransfer> transfers){
        return transfers.stream().map(this::convertParkingToEntity).collect(Collectors.toList());
    }

    public ParkingEntity convertParkingToEntity(ParkingTransfer transfer){
        ParkingEntity entity = new ParkingEntity();
        entity.setId(transfer.getId());
        entity.setAddress(transfer.getAddress());
        entity.setPrice(transfer.getPrice());
        entity.setName(transfer.getName());
        entity.setCarNumbers(transfer.getCarNumbers());
        entity.setNumberOfPlaces(transfer.getNumberOfPlaces());
        entity.setOccupiedPlaces(transfer.getOccupiedPlaces());
        entity.setAvailablePlaces(transfer.getAvailablePlaces());
        entity.setWorkingHours(transfer.getWorkingHours());

        return entity;
    }

}
