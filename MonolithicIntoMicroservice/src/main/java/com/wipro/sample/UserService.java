package com.wipro.sample;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() { return userRepository.findAll(); }
    public User createUser(User user) { return userRepository.save(user); }
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            return userRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}

