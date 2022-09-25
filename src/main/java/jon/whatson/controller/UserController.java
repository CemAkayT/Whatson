package jon.whatson.controller;

import jon.whatson.iservice.IUserService;
import jon.whatson.iservice.IVenueService;
import jon.whatson.model.User;
import jon.whatson.model.Venue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final IUserService iUserService;
    private final IVenueService iVenueService;

    public UserController(IUserService iUserService, IVenueService iVenueService) {
        this.iUserService = iUserService;
        this.iVenueService = iVenueService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> create(@RequestBody User user) {
        List<User> userList = iUserService.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equalsIgnoreCase(user.getName())) {
                return new ResponseEntity<>(user.getName() + " already exists!", HttpStatus.OK);
            }
        }
        iUserService.save(user);
        return new ResponseEntity<>("New User :\"" + user.getName() + "\" created", HttpStatus.OK);
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<User>> read() {
        if (!iUserService.findAll().isEmpty()) {
            return new ResponseEntity<>(iUserService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
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

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        if (!iUserService.existsById(id)) {
            return new ResponseEntity<>("User not found:", HttpStatus.OK);
        } else {
            iUserService.deleteById(id);
            return new ResponseEntity<>("User deleted:", HttpStatus.OK);
        }
    }

    @GetMapping("/existsUserById")
    public boolean existsByid(@RequestParam Long id){
        boolean found = false;
        if (!iUserService.existsById(id)){
            return found;
        } else{
            return !found;
        }
    }

    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> getUserByName(String name){
        return new ResponseEntity<>(iUserService.findUserByName(name), HttpStatus.OK);
    }


    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long venueID){
        Optional<User> user_ = iUserService.findById(userID);
        Optional<Venue> venue_ = iVenueService.findById(venueID);

        if (user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get());
            iUserService.save(user_.get());

            return new ResponseEntity<>("Like oprettet", HttpStatus.OK);
        }
        return new ResponseEntity<>("Ikke oprettet", HttpStatus.OK);
    }
}
