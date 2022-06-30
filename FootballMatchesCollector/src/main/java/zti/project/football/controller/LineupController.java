package zti.project.football.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zti.project.football.model.Lineup;
import zti.project.football.model.Player;
import zti.project.football.repository.ClubRepository;
import zti.project.football.repository.LineupRepository;
import zti.project.football.repository.PlayerRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LineupController {
    @Autowired
    LineupRepository lineupRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/lineups")
    public ResponseEntity<List<Lineup>> getAllLineups() {
        List<Lineup> lineups = new ArrayList<Lineup>();
        lineupRepository.findAll().forEach(lineups::add);

        if (lineups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lineups, HttpStatus.OK);
    }
    @GetMapping("/lineups/{id}")
    public ResponseEntity<Lineup> getLineupById(@PathVariable("id") long id) {
        Lineup lineup = lineupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Lineup with id = " + id));
        return new ResponseEntity<>(lineup, HttpStatus.OK);
    }
    @GetMapping("/clubs/{clubId}/lineups")
    public ResponseEntity<List<Lineup>> getAllPlayersByClubId(@PathVariable(value = "clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new RuntimeException("Not found Club with id = " + clubId);
        }
        List<Lineup> lineups = lineupRepository.findByClubId(clubId);
        return new ResponseEntity<>(lineups, HttpStatus.OK);
    }
    @PostMapping("/clubs/{clubId}/lineup")
    public ResponseEntity<Lineup> createLineup(@PathVariable(value = "clubId") Long clubId,
                                               @RequestBody Lineup lineupRequest) {
        Lineup lineup = clubRepository.findById(clubId).map(club -> {
            lineupRequest.setClub(club);
            return lineupRepository.save(lineupRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Club with id = " + clubId));
        return new ResponseEntity<>(lineup, HttpStatus.CREATED);
    }
    @PutMapping("/lineups/{id}")
    public ResponseEntity<Lineup> updateLineup(@PathVariable("id") long id, @RequestBody Lineup lineup) {
        Lineup _lineup = lineupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Lineup with id = " + id));
        _lineup.setGoals(lineup.getGoals());

        return new ResponseEntity<>(lineupRepository.save(_lineup), HttpStatus.OK);
    }
    @DeleteMapping("/lineups/{id}")
    public ResponseEntity<HttpStatus> deleteLineup(@PathVariable("id") long id) {
        lineupRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/lineups")
    public ResponseEntity<HttpStatus> deleteAllLineups() {
        lineupRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/lineups/{lineupId}/players")
    public ResponseEntity<List<Player>> getAllPlayersByLineupId(@PathVariable(value = "lineupId") Long lineupId) {
        if (!lineupRepository.existsById(lineupId)) {
            throw new RuntimeException("Not found Tutorial with id = " + lineupId);
        }
        List<Player> players = playerRepository.findPlayersByLineupsId(lineupId);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @GetMapping("/players/{playerId}/lineups")
    public ResponseEntity<List<Lineup>> getAllLineupsByPlayerId(@PathVariable(value = "playerId") Long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new RuntimeException("Not found Tutorial with id = " + playerId);
        }
        List<Lineup> lineups = lineupRepository.findLineupsByPlayersId(playerId);
        return new ResponseEntity<>(lineups, HttpStatus.OK);
    }
    @PostMapping("/lineups/{lineupId}/player")
    public ResponseEntity<Player> addPlayer(@PathVariable(value = "lineupId") Long lineupId, @RequestBody Player playerRequest) {
        Player tag = lineupRepository.findById(lineupId).map(lineup -> {
            long playerId = playerRequest.getId();

            // playerId is existed
            if (playerId != 0L) {
                Player _player = playerRepository.findById(playerId)
                        .orElseThrow(() -> new RuntimeException("Not found Tag with id = " + playerId));
                lineup.addPlayer(_player);
                lineupRepository.save(lineup);
                return _player;
            }

            // add and create new Tag
            lineup.addPlayer(playerRequest);
            return playerRepository.save(playerRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = " + lineupId));
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }
}
