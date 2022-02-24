package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "nba_action_figure")
public class NbaActionFigure implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "team")
    private String team;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @OneToOne
    @JoinColumn(unique = true)
    private PersonalDetails personalDetails;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getJerseyNumber() {
        return this.jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public PersonalDetails getPersonalDetails() {
        return this.personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NbaActionFigure)) return false;
        NbaActionFigure that = (NbaActionFigure) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "domain.NbaActionFigure{" +
                "id=" + getId() +
                ", playerName='" + getPlayerName() + '\'' +
                ", team='" + getTeam() + '\'' +
                ", jerseyNumber=" + getJerseyNumber() +
                ", personalDetails=" + getPersonalDetails() +
                '}';
    }
}
