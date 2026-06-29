package learn_spring_rest_api.demo.Users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.register(user);
        return ResponseEntity.ok(
                Map.of(
                  "message" , "Register with success",
                        "user" , newUser
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User authUser = userService.login(user.getEmail() , user.getPassword());
        return ResponseEntity.ok(
                Map.of(
                        "message" , "Login success",
                        "user" , authUser

                )
        );
    }
}
