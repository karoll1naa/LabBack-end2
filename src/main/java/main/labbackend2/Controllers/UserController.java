package main.labbackend2.Controllers;

import main.labbackend2.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        users.add(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return users;
    }
}
