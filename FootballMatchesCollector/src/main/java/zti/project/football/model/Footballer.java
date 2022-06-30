package zti.project.football.model;

import javax.persistence.*;

@Entity
@Table(name = "footballer")
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "club")
    private String club;

    public Footballer() {
    }
    public Footballer(String firstname, String lastname, int age, String club) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.club = club;
    }
    public Long getId() {
        return id;
    }
    public String getFirstName() { return firstname; }
    public void setFirstName(String firstname) { this.firstname = firstname; }
    public String getLastName() { return lastname; }
    public void setLastName(String lastname) { this.lastname = lastname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getClub() { return club; }
    public void setClub(String club) { this.club = club; }
    @Override
    public String toString() {
        return "fff gracz";
    }
}
