package learn_spring_rest_api.demo.Users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

//    Get All users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    Add user
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

//    Get user by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

//    Update User
    public User updateUser(Long id , User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

//    Delete User
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("user not found");
        }
        userRepository.deleteById(id);
    }

//    Login
    public User login(String email , String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
         if(!user.getPassword().equals(password)) {
             throw new RuntimeException("Password incorrect");
         }
         return user;
    }

//    Register
    public User register(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already in use");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
