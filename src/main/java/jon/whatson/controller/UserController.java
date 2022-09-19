package jon.whatson.controller;

import jon.whatson.model.User;
import jon.whatson.userservice.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> create(@RequestBody User user) {
        Set<User> userSet = iUserService.findAll();
            if (!userSet.contains(user)) {
                iUserService.save(user);
                return new ResponseEntity<>("New User created:", HttpStatus.OK);
            }
        return new ResponseEntity<>("User already exists:", HttpStatus.OK);
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<String> read() {
        if (!iUserService.findAll().isEmpty()) {
            return new ResponseEntity<>("Users: " + iUserService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table is empty!", HttpStatus.OK);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> update(Long id, @RequestBody User user) {
        if (iUserService.existsById(id)) {
            user.setId(id);
            iUserService.save(user);
            return new ResponseEntity<>("User updated:", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found:", HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteUserByID")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        if (!iUserService.existsById(id)) {
            return new ResponseEntity<>("User not found:", HttpStatus.OK);
        } else {
            iUserService.deleteById(id);
            return new ResponseEntity<>("User deleted:", HttpStatus.OK);
        }
    }
}
