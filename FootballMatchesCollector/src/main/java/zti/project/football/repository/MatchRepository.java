package zti.project.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zti.project.football.model.Match;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByHomeClubContaining(String club);
    List<Match> findByAwayClubContaining(String club);
}
