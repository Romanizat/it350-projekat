package romanizat.esports.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "game")
@RequiredArgsConstructor
@ToString
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "publisher")
    private String publisher;
    //    @JsonIgnore
    @ManyToMany()
    @JoinTable(name = "game_genre",
            joinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "genre_id")})
    private List<Genre> genres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id.equals(game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonGetter
    public List<Integer> getGenres() {
        List<Integer> genreIds = new ArrayList<>();
        if (this.genres == null || this.genres.isEmpty()) return null;
        for (Genre genre : this.genres) {
            genreIds.add(genre.getId());
        }
        return genreIds;
    }
}