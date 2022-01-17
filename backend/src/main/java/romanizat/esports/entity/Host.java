package romanizat.esports.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "host")
@RequiredArgsConstructor
public class Host implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "host_id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "jmbg")
    private String jmbg;
    @Column(name = "years_experience")
    private Integer yearsExperience;
    @ManyToMany()
    @JoinTable(name = "tournament_host",
            joinColumns = {@JoinColumn(name = "host_id", referencedColumnName = "host_id")},
            inverseJoinColumns = {@JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")})
    private List<Tournament> tournaments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return id.equals(host.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonGetter
    public List<Integer> getTournaments() {
        List<Integer> tournamentIds = new ArrayList<>();
        if (this.tournaments == null || this.tournaments.isEmpty()) return null;
        for (Tournament tournament : this.tournaments) {
            tournamentIds.add(tournament.getId());
        }
        return tournamentIds;
    }
}