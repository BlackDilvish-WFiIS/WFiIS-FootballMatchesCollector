package zti.project.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zti.project.football.model.Club;
import zti.project.football.model.Footballer;
import zti.project.football.model.Lineup;
import zti.project.football.model.Match;
import zti.project.football.repository.ClubRepository;
import zti.project.football.repository.LineupRepository;
import zti.project.football.repository.MatchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Klasa MatchController obslugujaca endpointy dotyczace meczy pilkarskich
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MatchController {
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    LineupRepository lineupRepository;
    @Autowired
    ClubRepository clubRepository;

    /**
     * Zwraca wszystkie mecze lub takie w ktorych wystapil podany klub
     * @param club
     * @return
     */
    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getAllMatches(@RequestParam(required = false) String club) {
        try {
            List<Match> matches = new ArrayList<Match>();

            if (club != null)
            {
                matchRepository.findByHomeClubContaining(club).forEach(matches::add);
                matchRepository.findByAwayClubContaining(club).forEach(matches::add);
            }
            else
                matchRepository.findAll().forEach(matches::add);

            if (matches.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Wyszukuje mecz o danym id
     * @param id
     * @return
     */
    @GetMapping("/matches/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Lineup with id = " + id));
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    /**
     * Zapisuje w bazie nowy mecz
     * @param match
     * @return
     */
    @PostMapping("/matches")
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        try {
            Match _match = matchRepository
                    .save(new Match(match.getDate(), match.getResult(), match.getHomeClub(), match.getAwayClub(),
                            match.getAwayGoalkeeper(), match.getAwayLeftBack(), match.getAwayLeftCenterBack(),
                            match.getAwayRightCenterBack(), match.getAwayRightBack(), match.getAwayLeftMidfielder(),
                            match.getAwayLeftCenterMidfielder(), match.getAwayRightCenterMidfielder(),
                            match.getAwayRightMidfielder(), match.getAwayLeftStriker(), match.getAwayRightStriker(),
                            match.getHomeGoalkeeper(), match.getHomeLeftBack(), match.getHomeLeftCenterBack(),
                            match.getHomeRightCenterBack(), match.getHomeRightBack(), match.getHomeLeftMidfielder(),
                            match.getHomeLeftCenterMidfielder(), match.getHomeRightCenterMidfielder(),
                            match.getHomeRightMidfielder(), match.getHomeLeftStriker(), match.getHomeRightStriker()
                            ));
            return new ResponseEntity<>(_match, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Aktualizuje dane meczu
     * @param id
     * @param match
     * @return
     */
    @PutMapping("/matches/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable("id") long id, @RequestBody Match match) {
        Optional<Match> _matchData = matchRepository.findById(id);
        if (_matchData.isPresent()) {
            Match _match = _matchData.get();
            _match.setDate(match.getDate());
            _match.setResult(match.getResult());
            _match.setHomeClub(match.getHomeClub());
            _match.setAwayClub(match.getAwayClub());
            _match.setAwayGoalkeeper(match.getAwayGoalkeeper());
            _match.setAwayLeftBack(match.getAwayLeftBack());
            _match.setAwayLeftCenterBack(match.getAwayLeftCenterBack());
            _match.setAwayRightCenterBack(match.getAwayRightCenterBack());
            _match.setAwayRightBack(match.getAwayRightBack());
            _match.setAwayLeftMidfielder(match.getAwayLeftMidfielder());
            _match.setAwayLeftCenterMidfielder(match.getAwayLeftCenterMidfielder());
            _match.setAwayRightCenterMidfielder(match.getAwayRightCenterMidfielder());
            _match.setAwayRightMidfielder(match.getAwayRightMidfielder());
            _match.setAwayLeftStriker(match.getAwayLeftStriker());
            _match.setAwayRightStriker(match.getAwayRightStriker());
            _match.setHomeGoalkeeper(match.getHomeGoalkeeper());
            _match.setHomeLeftBack(match.getHomeLeftBack());
            _match.setHomeLeftCenterBack(match.getHomeLeftCenterBack());
            _match.setHomeRightCenterBack(match.getHomeRightCenterBack());
            _match.setHomeRightBack(match.getHomeRightBack());
            _match.setHomeLeftMidfielder(match.getHomeLeftMidfielder());
            _match.setHomeLeftCenterMidfielder(match.getHomeLeftCenterMidfielder());
            _match.setHomeRightCenterMidfielder(match.getHomeRightCenterMidfielder());
            _match.setHomeRightMidfielder(match.getHomeRightMidfielder());
            _match.setHomeLeftStriker(match.getHomeLeftStriker());
            _match.setHomeRightStriker(match.getHomeRightStriker());
            return new ResponseEntity<>(matchRepository.save(_match), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Usuwa dane meczu
     * @param id
     * @return
     */
    @DeleteMapping("/matches/{id}")
    public ResponseEntity<HttpStatus> deleteMatch(@PathVariable("id") long id) {
        try {
            matchRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Usuwa wszystkie mecze
     * @return
     */
    @DeleteMapping("/matches")
    public ResponseEntity<HttpStatus> deleteAllMatches() {
        try {
            matchRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
