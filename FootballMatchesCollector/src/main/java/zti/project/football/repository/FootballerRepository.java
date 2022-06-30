package zti.project.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zti.project.football.model.Footballer;

import java.util.List;

public interface FootballerRepository  extends JpaRepository<Footballer, Long> {
    List<Footballer> findByClubContaining(String club);
    List<Footballer> findByLastnameContaining(String lastname);
}
