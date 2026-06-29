package learn_spring_rest_api.demo.Group;

import java.time.LocalDate;

public record Group(Long id , String name , String description , String city , String organizer , LocalDate createdDate) {
}
