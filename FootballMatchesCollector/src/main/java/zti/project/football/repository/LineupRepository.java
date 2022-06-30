package zti.project.football.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import zti.project.football.model.Lineup;

public interface LineupRepository extends JpaRepository<Lineup, Long> {
    List<Lineup> findLineupsByPlayersId(Long playerId);
    List<Lineup> findByClubId(Long clubId);
}
