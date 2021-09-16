package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pojo.Horoscope;
import repositories.HoroscopeRepository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Controller for horoscopes
 */

@RestController
public class HoroscopeController {

    Logger logger = Logger.getLogger("HoroscopeControllerLogger");

    private final HoroscopeRepository horoscopeRepository;

    public HoroscopeController(HoroscopeRepository horoscopeRepository) {
        this.horoscopeRepository = horoscopeRepository;
    }

    /**
     * @param id the horoscope id in the DB
     * @return the horoscope details
     */
    @GetMapping("/horoscope/{id}")
    public ResponseEntity<Horoscope> one(@PathVariable Long id) {
        Optional<Horoscope> horoscopeOptional = horoscopeRepository.findById(id);
        if (horoscopeOptional.isEmpty()) {
            logger.log(Level.WARNING, "Horoscope with ID " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.log(Level.INFO, "Horoscope with ID " + id + " found");
            return new ResponseEntity<Horoscope>(horoscopeOptional.get(), HttpStatus.OK);
        }
    }

}
