package zti.project.football.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zti.project.football.model.Club;
import zti.project.football.repository.ClubRepository;

/**
 * Kontroler rutingu danych o klubach pilkarskich
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClubController {
    @Autowired
    ClubRepository clubRepository;

    /**
     * Zwraca wszystkie kluby lub te zawierajace okreslona nazwe
     * @param name
     * @return
     */
    @GetMapping("/clubs")
    public ResponseEntity<List<Club>> getAllClubs(@RequestParam(required = false) String name) {
        try {
            List<Club> clubs = new ArrayList<Club>();
            if (name == null)
                clubRepository.findAll().forEach(clubs::add);
            else
                clubRepository.findByNameContaining(name).forEach(clubs::add);
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clubs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Zwraca klub o danym id
     * @param id
     * @return
     */
    @GetMapping("/clubs/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable("id") long id) {
        Optional<Club> clubData = clubRepository.findById(id);
        if (clubData.isPresent()) {
            return new ResponseEntity<>(clubData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Tworzy nowy klub
     * @param club
     * @return
     */
    @PostMapping("/clubs")
    public ResponseEntity<Club> createClub(@RequestBody Club club) {
        try {
            Club _club = clubRepository
                    .save(new Club(club.getName(), club.getCountry(), club.getLeague()));
            return new ResponseEntity<>(_club, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Aktualizuje dane klubu
     * @param id
     * @param club
     * @return
     */
    @PutMapping("/clubs/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable("id") long id, @RequestBody Club club) {
        Optional<Club> clubData = clubRepository.findById(id);
        if (clubData.isPresent()) {
            Club _club = clubData.get();
            _club.setName(club.getName());
            _club.setCountry(club.getCountry());
            _club.setLeague(club.getLeague());
            return new ResponseEntity<>(clubRepository.save(_club), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Usuwa klub o zadanym id
     * @param id
     * @return
     */
    @DeleteMapping("/clubs/{id}")
    public ResponseEntity<HttpStatus> deleteClub(@PathVariable("id") long id) {
        try {
            clubRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Usuwa wszystkie kluby
     * @return
     */
    @DeleteMapping("/clubs")
    public ResponseEntity<HttpStatus> deleteAllClubs() {
        try {
            clubRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/clubs/league")
    public ResponseEntity<List<Club>> findByPublished(@RequestParam(required = true) String league) {
        try {
            List<Club> clubs = clubRepository.findByLeagueContaining(league);
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clubs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
