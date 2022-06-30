package zti.project.football.model;

import javax.persistence.*;
@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "league")
    private String league;
    public Club() {
    }
    public Club(String name, String country, String league) {
        this.name = name;
        this.country = country;
        this.league = league;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLeague() {
        return league;
    }
    public void setLeague(String league) {
        this.league = league;
    }
    @Override
    public String toString() {
        return "Club klub";
    }
}
