package ru.study.parking.dao.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.study.parking.dao.interfaces.ParkingService;
import ru.study.parking.entity.ParkingEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ParkingDao implements ParkingService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ParkingEntity> findAll() {
        return em.createQuery("select p from ParkingEntity p", ParkingEntity.class).getResultList();
    }

    @Override
    public ParkingEntity findById(Long id) {
        return em.createQuery("select p from ParkingEntity p where p.id = :id", ParkingEntity.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .get(0);
    }

    @Override
    public void addParking(ParkingEntity parking) {
        em.persist(parking);
    }

    @Override
    public List<ParkingEntity> findOpenParking(LocalDateTime time) {
        LocalTime now = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond(), time.getNano());

        List<ParkingEntity> parking = findAll();
        return parking.stream().filter(p ->
                p.getWorkingHours().get(time.getDayOfWeek().getValue()).get(0).isBefore(now) &&
                        p.getWorkingHours().get(time.getDayOfWeek().getValue()).get(1).isAfter(now)
        ).collect(Collectors.toList());
    }

    @Override
    public void addCar(ParkingEntity parking) {
        em.merge(parking);
    }

    @Override
    public void removeCar(Long parkingId, String carNumber) {
        ParkingEntity parking = findById(parkingId);
        for (String number : parking.getCarNumbers()) {
            if (number.equals(carNumber)) {
                parking.getCarNumbers().remove(carNumber);
                parking.setOccupiedPlaces(parking.getOccupiedPlaces() - 1);
                parking.setAvailablePlaces(parking.getAvailablePlaces() + 1);
                break;
            }
        }
        em.merge(parking);
    }

    @Override
    public void updateRating(ParkingEntity parking) {
        em.merge(parking);
    }
}
