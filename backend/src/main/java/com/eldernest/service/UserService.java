package com.eldernest.service;
import com.eldernest.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.eldernest.model.User;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User>getUserById(Long id){
        return userRepository.findById(id);
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public boolean deleteUser(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public User updateUser(Long id, User updatedUser){
        Optional<User> exisingUser = userRepository.findById(id);
        if (exisingUser.isPresent()){
            User user = exisingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }
        return null;
     }
}
