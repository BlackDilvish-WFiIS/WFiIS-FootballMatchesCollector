package zti.project.football.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.sound.sampled.Line;

@Entity
@Table(name = "lineup")
public class Lineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "goals")
    private int goals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "club_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Club club;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "lineup_player",
            joinColumns = { @JoinColumn(name = "lineup_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") })
    private Set<Player> players = new HashSet<>();

    public Lineup()
    {
    }

    public Lineup(int goals)
    {
        this.goals = goals;
    }

    public long getId() {
        return id;
    }
    public int getGoals() { return goals; }
    public void setGoals(int goals) { this.goals = goals; }
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }

    public void addPlayer(Player player) {
        this.players.add(player);
        player.getLineups().add(this);
    }

    public void removePlayer(long playerId) {
        Player player = this.players.stream().filter(p -> p.getId() == playerId).findFirst().orElse(null);
        if (player != null) {
            this.players.remove(player);
            player.getLineups().remove(this);
        }
    }

    public Match getMatch() { return this.match; }
    public void setMatch(Match match) { this.match = match; }

    @Override
    public String toString() {
        return "sklad gracza";
    }
}
