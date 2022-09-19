package jon.whatson.controller;

import jon.whatson.bandservice.IBandService;
import jon.whatson.model.Band;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BandController {

    private IBandService iBandService;

    public BandController(IBandService bandService) {
        this.iBandService = bandService;
    }

    /* @PostMapping("/createBand")
     public ResponseEntity<String> createBand(@RequestBody Band band){
         String msg="";
         if(iBandService.save(band)!=null) {
             msg="Oprettet band: "+band.getName();
         }else {
             msg="fejl i oprettelse af " + band.getName();
         }
         return new ResponseEntity<>(msg, HttpStatus.OK);
     }
 */
    @PostMapping("/createBand")
    public ResponseEntity<Set<Band>> createBand(@RequestBody Band band) {
        Set<Band> bandSet = iBandService.findAll();
        if (!bandSet.contains(band)) {
            iBandService.save(band);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }

    @GetMapping("/fetchAllBands")
    public ResponseEntity<String> read(){
        if (!iBandService.findAll().isEmpty()){
            return new ResponseEntity<>("Bands: " + iBandService.findAll(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Table is empty!", HttpStatus.OK);
        }

    }
}