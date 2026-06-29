package learn_spring_rest_api.demo.Group;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private List<Group> groups = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public GroupController() {
        System.out.println("Group Controller loaded");
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Group 1 ",
                "Group 1 the best group ever",
                "Casablanca",
                "ZAHIR Youness",
                LocalDate.of(2020,3,1)
        ));
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Group 2",
                "Group 2 the best group ever",
                "Rabat",
                "RACHIDY Med Reda",
                LocalDate.of(2020,3,1)
        ));
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Group 3 ",
                "Group 3 the best group ever",
                "Fes",
                "BIDAH Oussama",
                LocalDate.of(2020,3,1)
        ));
    }

    @GetMapping("/")
    List<Group> getGroups(){
        return groups;
    }

    @GetMapping("/{id}")
    Optional<Group> getGroupById(@PathVariable Long id){
        return groups.stream().filter(g -> g.id().equals(id)).findFirst();
    }

}
