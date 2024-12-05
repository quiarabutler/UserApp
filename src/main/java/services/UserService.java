package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepo;

import java.util.List;

@Service // Handles business logic
public class UserService {

    @Autowired // Allows spring to automatically inject dependencies
    private UserRepo userRepo; // injects the repo so the service can have access to it

    public List<User> getAllUser(){ //a list that will contain all users
        return userRepo.findAll();
    }

    public User createUser(User user){ // Once a user is created it will be saved in the repo and will go into the database
        return userRepo.save(user);
    }

    public User updateUser(Long id, User upateUser){
       return userRepo.findById(id).map(user -> {
           user.setName(upateUser.getName());
           user.setEmail(upateUser.getEmail());
           return userRepo.save(user);
       }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
