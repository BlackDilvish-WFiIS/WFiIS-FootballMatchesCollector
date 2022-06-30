package zti.project.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zti.project.football.model.Footballer;
import zti.project.football.repository.FootballerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Kontroler odpowiadajacy za ruting danych dotyczacych pilkarzy
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FootballerController {
    @Autowired
    FootballerRepository footballerRepository;

    /**
     * Zwraca wszystkich pilkarzy lub tych zawierajacych podane nazwisko lub klub
     * @param lastname
     * @param club
     * @return
     */
    @GetMapping("/footballers")
    public ResponseEntity<List<Footballer>> getAllFootballers(@RequestParam(required = false) String lastname,
                                                              @RequestParam(required = false) String club) {
        try {
            List<Footballer> players = new ArrayList<Footballer>();
            if (lastname != null)
                footballerRepository.findByLastnameContaining(lastname).forEach(players::add);
            else if (club != null)
                footballerRepository.findByClubContaining(club).forEach(players::add);
            else
                footballerRepository.findAll().forEach(players::add);
            if (players.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(players, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Tworzy nowego pilkarza w bazie
     * @param player
     * @return
     */
    @PostMapping("/footballers")
    public ResponseEntity<Footballer> createFootballers(@RequestBody Footballer player) {
        try {
            Footballer _player = footballerRepository
                    .save(new Footballer(player.getFirstName(), player.getLastName(), player.getAge(), player.getClub()));
            return new ResponseEntity<>(_player, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Zwraca pilkarza o zadanym id
     * @param id
     * @return
     */
    @GetMapping("/footballers/{id}")
    public ResponseEntity<Footballer> getFootballerById(@PathVariable("id") long id) {
        Optional<Footballer> playerData = footballerRepository.findById(id);
        if (playerData.isPresent()) {
            return new ResponseEntity<>(playerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Aktualizuje dane pilkarza
     * @param id
     * @param player
     * @return
     */
    @PutMapping("/footballers/{id}")
    public ResponseEntity<Footballer> updateFootballer(@PathVariable("id") long id, @RequestBody Footballer player) {
        Optional<Footballer> _playerData = footballerRepository.findById(id);
        if (_playerData.isPresent()) {
            Footballer _player = _playerData.get();
            _player.setFirstName(player.getFirstName());
            _player.setLastName(player.getLastName());
            _player.setAge(player.getAge());
            _player.setClub(player.getClub());
            return new ResponseEntity<>(footballerRepository.save(_player), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Usuwa danego pilkarza
     * @param id
     * @return
     */
    @DeleteMapping("/footballers/{id}")
    public ResponseEntity<HttpStatus> deleteFootballer(@PathVariable("id") long id) {
        try {
            footballerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Usuwa wszystkich pilkarzy
     * @return
     */
    @DeleteMapping("/footballers")
    public ResponseEntity<HttpStatus> deleteAllFootballers() {
        try {
            footballerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
