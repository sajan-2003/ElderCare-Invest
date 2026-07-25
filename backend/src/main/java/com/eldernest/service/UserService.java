package com.eldernest.service;
import org.springframework.stereotype.Service;
import com.eldernest.model.User;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(
                1L,
                "sajan",
                "sajanchamika@email.com",
                "INVESTOR"
        ));
        users.add(new User(
                2L,
                "Nimal",
                "Nimal@email.com",
                "GUARDIAN"
        ));

    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserById(Long id) {
        for (int i=0; i< users.size(); i++){
            if (users.get(i).getId().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }
    public User addUser(User user) {
        users.add(user);
        return user;
    }
    public boolean deleteUser(Long id){
        for (int i=0; i< users.size(); i++){
            if (users!=null && users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public User updateUser(Long id, User updatedUser) {
        String name = updatedUser.getName();
        String email = updatedUser.getEmail();
        String role = updatedUser.getRole();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.get(i).setName(name);
                users.get(i).setEmail(email);
                users.get(i).setRole(role);

                return users.get(i);
            }

        }
        return null;
    }
}
