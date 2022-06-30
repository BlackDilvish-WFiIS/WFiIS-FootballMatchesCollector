package zti.project.football.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import zti.project.football.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByClubId(Long postId);
    List<Player> findPlayersByLineupsId(Long lineupId);

    @Transactional
    void deleteByClubId(long clubId);
}