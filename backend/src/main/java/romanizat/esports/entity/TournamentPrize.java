package romanizat.esports.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tournament_prize")
public class TournamentPrize implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_prize_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "prize_id", referencedColumnName = "prize_id")
    private Prize prizeId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team teamId;
    @ManyToOne
    @JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")
    private Tournament tournamentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentPrize tournamentPrize = (TournamentPrize) o;
        return id.equals(tournamentPrize.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}