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
@Table(name = "arena")
@RequiredArgsConstructor
public class Arena implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arena_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "country")
	private String country;
	@Column(name = "city")
	private String city;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Arena arena = (Arena) o;
		return id.equals(arena.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}