package ru.study.parking.dao.dao;

import org.springframework.stereotype.Repository;
import ru.study.parking.dao.interfaces.UserService;
import ru.study.parking.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity save(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Override
    public UserEntity getById(String id) {
        List<UserEntity> user = em.createQuery("select u from UserEntity u where u.id = :id", UserEntity.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList();
        return user.size() > 0 ? user.get(0) : null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return em.merge(userEntity);
    }
}
