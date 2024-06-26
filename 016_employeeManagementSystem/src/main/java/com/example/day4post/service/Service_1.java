package com.example.day4post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day4post.model.User;
import com.example.day4post.repository.Repository;
@Service
public class Service_1
{
    @Autowired
    public Repository ab;
    // private PasswordEncoun pe;

    //create new user

    public User createnewuser(@NonNull User user)
    {
        return ab.save(user);
    }

    //getuser

    public List<User> getAllusers()
    {
        return ab.findAll();
    }

    //EIETHER WAYS WE CAN FINDALL THE USERS BY FINDALL AS WELL AS THROUGH THE EMAIL
    
    //getuserusingemailid
    
    public Optional<User> getModelByEmail(String email)
    {
        return ab.findByEmail(email);
    }

    //updateUser

    public User updateUser(@NonNull String email,@RequestBody User user)
    {
        return ab.findByEmail(email)
        .map(existingUser -> {
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ email));

    }
    public Optional<User> getModelByprofession(String profession)
    {
        return ab.findByProfession(profession);
    }

    //updateUser

    public User updateProfession(@NonNull String profession,@RequestBody User user)
    {
        return ab.findByProfession(profession)
        .map(existingUser -> {
        existingUser.setName(user.getName());
        existingUser.setProfession(user.getProfession());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this profession: "+ profession));

    }
    public Optional<User> getModelBySalary(int salary)
    {
        return ab.findBySalary(salary);
    }

    //updateUser

    public User updateSalary(int salary,@RequestBody User user)
    {
        return ab.findBySalary(salary)
        .map(existingUser -> {
        existingUser.setName(user.getName());
        existingUser.setSalary(user.getSalary());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this salary: "+ salary));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }

    
}