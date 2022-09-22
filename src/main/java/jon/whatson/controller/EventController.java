package jon.whatson.controller;

import jon.whatson.iservice.IBandService;
import jon.whatson.iservice.IEventService;
import jon.whatson.model.Band;
import jon.whatson.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


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
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not create", HttpStatus.OK);
        }

    }

}


