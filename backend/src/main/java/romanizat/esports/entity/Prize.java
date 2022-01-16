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
@Table(name = "prize")
@RequiredArgsConstructor
public class Prize implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prize_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")
	private Sponsor sponsorId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prize prize = (Prize) o;
		return id.equals(prize.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}