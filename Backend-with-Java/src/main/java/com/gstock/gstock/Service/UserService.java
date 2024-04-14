package com.gstock.gstock.Service;

import com.gstock.gstock.Repository.UserRepository;
import com.gstock.gstock.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> authenticate(String username, String password) {
        return userRepository.findByUserNameAndUserPassword(username, password);
    }

    public boolean isUserAdmin(User user) {
        return user.getRole().equals(User.Role.ADMINISTRATEUR);
    }
}
