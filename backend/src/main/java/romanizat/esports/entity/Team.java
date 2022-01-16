package romanizat.esports.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "team")
@RequiredArgsConstructor
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pc_id", referencedColumnName = "pc_id")
    private Pc pcId;
    @Column(name = "name")
    private String name;
    @Column(name = "year_est")
    private Integer yearEst;
    @Column(name = "tag")
    private String tag;
    @ManyToMany()
    @JoinTable(name = "team_sponsor", joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")})
    private List<Sponsor> sponsors;
    @ManyToMany()
    @JoinTable(name = "tournament_team",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")})
    private List<Tournament> tournaments;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}