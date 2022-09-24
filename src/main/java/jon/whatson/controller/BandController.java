package jon.whatson.controller;

import jon.whatson.iservice.IBandService;
import jon.whatson.model.Band;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;


@RestController
public class BandController {

    private IBandService iBandService;

    public BandController(IBandService bandService) {
        this.iBandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> create(@RequestBody Band band) {
        List<Band> bandList = iBandService.findAll();
        for (Band value : bandList) {
            if (value.getName().equalsIgnoreCase(band.getName())) {
                return new ResponseEntity<>(band.getName() + " already exist", HttpStatus.OK);
            }
        }
        iBandService.save(band);
        return new ResponseEntity<>("New Band: " + band.getName() + " created", HttpStatus.OK);
    }

    @GetMapping("/fetchAllBands")
    public ResponseEntity<List<Band>> read() {
        if (!iBandService.findAll().isEmpty()) {
            return new ResponseEntity<>( iBandService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PutMapping("/updateBand")
    public ResponseEntity<String> update(Long id, @RequestBody Band band) {
        if (iBandService.existsById(id)) {
            band.setId(id);
            iBandService.save(band);
            return new ResponseEntity<>("Band updated:", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band not found:", HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteBandById")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        if (!iBandService.existsById(id)) {
            return new ResponseEntity<>("User not found:", HttpStatus.OK);
        } else {
            iBandService.deleteById(id);
            return new ResponseEntity<>("User deleted:", HttpStatus.OK);
        }
    }

    @GetMapping("/existsBandById")
    public boolean existsByid(@RequestParam Long id){
        boolean found = false;
        if (!iBandService.existsById(id)){
            return found;
        } else{
            return !found;
        }
    }
    @GetMapping("/getBandByName") // look in repo
    public ResponseEntity<List<Band>> getBandByName(String name){
        return new ResponseEntity<>(iBandService.findBandByName(name), HttpStatus.OK);
    }
}

