package learn_spring_rest_api.demo.Users;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(){}

    public User(String email , String password , LocalDateTime createdAt){
        this.email = email;
        this.password = password;
        this.createdAt = createdAt.now();
    }

    public String getEmail () {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public void  setPassword(String password) {
        this.password = password;
    }
}
