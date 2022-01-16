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
@RequiredArgsConstructor
@Table(name = "tournament")
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "arena_id", referencedColumnName = "arena_id")
    private Arena arenaId;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game gameId;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @ManyToMany()
    @JoinTable(name = "tournament_team",
            joinColumns = {@JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")})
    private List<Team> teams;
    @ManyToMany()
    @JoinTable(name = "tournament_host",
            joinColumns = {@JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")},
            inverseJoinColumns = {@JoinColumn(name = "host_id", referencedColumnName = "host_id")})
    private List<Host> hosts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return id.equals(tournament.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}