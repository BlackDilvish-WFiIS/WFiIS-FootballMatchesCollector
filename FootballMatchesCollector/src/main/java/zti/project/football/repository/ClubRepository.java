package zti.project.football.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import zti.project.football.model.Club;
public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findByNameContaining(String name);
    List<Club> findByLeagueContaining(String league);
}
