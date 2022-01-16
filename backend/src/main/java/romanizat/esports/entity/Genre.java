package romanizat.esports.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "genre")
@RequiredArgsConstructor
@ToString
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @ManyToMany()
    @JoinTable(name = "game_genre",
            joinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "game_id")})
    private List<Game> games;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id.equals(genre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}