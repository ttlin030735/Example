package com.revature.Service;


import com.revature.Entity.User;
import com.revature.Repository.IUserRepo;
import com.revature.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final IUserRepo userRepo;

    @Autowired
    public UserService(IUserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> findAllUser(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        User exist = findByUserID(user.getUserId());
        if(exist != null){
            return userRepo.save(user);
        }
        return null;
    }

    public User findByUserID(Long userID) {
        return userRepo.findByuserID(userID).orElseThrow(() -> new UserNotFoundException("User by id " + userID + " was not found"));
    }


}
