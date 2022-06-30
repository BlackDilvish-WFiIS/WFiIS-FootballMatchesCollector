package zti.project.football.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import zti.project.football.model.Player;
import zti.project.football.repository.ClubRepository;
import zti.project.football.repository.PlayerRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @GetMapping("/clubs/{clubId}/players")
    public ResponseEntity<List<Player>> getAllPlayersByClubId(@PathVariable(value = "clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new RuntimeException("Not found Club with id = " + clubId);
        }
        List<Player> players = playerRepository.findByClubId(clubId);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @GetMapping("/players2/{id}")
    public ResponseEntity<Player> getPlayersByClubId(@PathVariable(value = "id") Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Player with id = " + id));
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
    @PostMapping("/clubs/{clubId}/player")
    public ResponseEntity<Player> createPlayer(@PathVariable(value = "clubId") Long clubId,
                                                 @RequestBody Player playerRequest) {
        Player player = clubRepository.findById(clubId).map(club -> {
            playerRequest.setClub(club);
            return playerRepository.save(playerRequest);
        }).orElseThrow(() -> new RuntimeException("Not found Club with id = " + clubId));
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
    @PutMapping("/player2/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id, @RequestBody Player playerRequest) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PlayerId " + id + "not found"));
        player.setFirstName(playerRequest.getFirstName());
        player.setLastName(playerRequest.getLastName());
        player.setAge(playerRequest.getAge());
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }
    @DeleteMapping("/player2/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable("id") long id) {
        playerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/clubs/{clubId}/player")
    public ResponseEntity<List<Player>> deleteAllPlayersOfClub(@PathVariable(value = "clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new RuntimeException("Not found Club with id = " + clubId);
        }
        playerRepository.deleteByClubId(clubId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
