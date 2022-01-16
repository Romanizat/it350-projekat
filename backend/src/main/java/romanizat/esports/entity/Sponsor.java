package romanizat.esports.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "sponsor")
@RequiredArgsConstructor
public class Sponsor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsor_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany()
    @JoinTable(name = "team_sponsor",
            joinColumns = {@JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")})
    private List<Team> teams;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return id.equals(sponsor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}