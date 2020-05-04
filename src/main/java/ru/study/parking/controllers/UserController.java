package ru.study.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.study.parking.dao.interfaces.UserService;
import ru.study.parking.entity.UserEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserEntity getCurrentUser(@AuthenticationPrincipal UserEntity user) {
        return user;
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping
    public void addCar(@AuthenticationPrincipal UserEntity user, @RequestBody String carNumber) {
        user.getCars().add(carNumber);
        userService.update(user);
    }

    @DeleteMapping
    public void removeCar(@AuthenticationPrincipal UserEntity userEntity, @RequestBody String carNumber){
        for (String car : userEntity.getCars()) {
            if(carNumber.equals(car)){
                userEntity.getCars().remove(car);
                break;
            }
        }
        userService.update(userEntity);
    }
}
