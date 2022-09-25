package jon.whatson.controller;

import jon.whatson.iservice.IEventService;
import jon.whatson.iservice.IReviewService;
import jon.whatson.iservice.IUserService;
import jon.whatson.model.Event;
import jon.whatson.model.Review;
import jon.whatson.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    private final IUserService iUserService;
    private final IEventService iEventService;
    private final IReviewService iReviewService;

    public ReviewController(IUserService iUserService, IEventService iEventService, IReviewService iReviewService) {
        this.iUserService = iUserService;
        this.iEventService = iEventService;
        this.iReviewService = iReviewService;
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> create(@RequestBody Review review, @RequestParam Long userID, @RequestParam Long eventID){
        Optional<User> user_ = iUserService.findById(userID);
        Optional<Event> event_ = iEventService.findById(eventID);
        if (user_.isPresent() && event_.isPresent()){
            review.setUser(user_.get());
            review.setEvent(event_.get());
            iReviewService.save(review);
            return new ResponseEntity<>("Review saved:", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not saved:", HttpStatus.OK);
    }

    @GetMapping("/fetchAllReviews")
    public ResponseEntity <List<Review>> read(){
        if (!iReviewService.findAll().isEmpty()){
            return new ResponseEntity<>(iReviewService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PutMapping("/updateReview")
    public ResponseEntity <String> update(Long id, @RequestBody Review review, @RequestParam Long userID, @RequestParam Long eventID){
        Optional<User> user_ = iUserService.findById(userID);
        Optional<Event> event_ = iEventService.findById(eventID);
        if (user_.isPresent() && event_.isPresent() && iReviewService.existsById(id)){
            review.setUser(user_.get());
            review.setEvent(event_.get());
            review.setId(id);
            iReviewService.save(review);
            return new ResponseEntity<>("Review updated: ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found:", HttpStatus.OK);
    }

    @DeleteMapping("/deleteReviewById")
    public ResponseEntity<String> delete(Long id){
        if(!iReviewService.existsById(id)){
            return new ResponseEntity<>("Review not found:", HttpStatus.OK);
        } else{
            iReviewService.deleteById(id);
            return new ResponseEntity<>("Review deleted:", HttpStatus.OK);

        }
    }




}
