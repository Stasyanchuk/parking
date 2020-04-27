package ru.study.parking.dao.interfaces;

import ru.study.parking.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface UserService {

    public UserEntity save(UserEntity user);
    public UserEntity getById(String id);
    public List<UserEntity> getAllUsers();
    public UserEntity update(UserEntity userEntity);

}
