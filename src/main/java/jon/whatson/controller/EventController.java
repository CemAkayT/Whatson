package jon.whatson.controller;

import jon.whatson.iservice.IBandService;
import jon.whatson.iservice.IEventService;
import jon.whatson.model.Band;
import jon.whatson.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class EventController {

    private IEventService iEventService;
    private IBandService iBandService;

    public EventController(IEventService eventService, IBandService iBandService) {
        this.iEventService = eventService;
        this.iBandService = iBandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID) {
        Optional<Band> band_ = iBandService.findById(bandID);
        if (band_.isPresent()) {
            event.setBand(band_.get());
            iEventService.save(event);
            return new ResponseEntity<>("Event saved: ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not create", HttpStatus.OK);
        }

    }

    @GetMapping("/fetchAllEvents")
    public ResponseEntity <List<Event>> read(){
        if (!iEventService.findAll().isEmpty()){
            return new ResponseEntity<>(iEventService.findAll(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PutMapping("/updateEvent")
    public ResponseEntity<String> update(Long id, @RequestBody Event event) {
        if (iEventService.existsById(id)) {
            event.setId(id);
            iEventService.save(event);
            return new ResponseEntity<>("Event updated:", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Event not found:", HttpStatus.OK);
        }
    }

}


