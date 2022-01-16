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
@Table(name = "pc")
@RequiredArgsConstructor
public class Pc implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pc_id")
	private Integer id;
	@Column(name = "gpu")
	private String gpu;
	@Column(name = "cpu")
	private String cpu;
	@Column(name = "ram")
	private Integer ram;
	@Column(name = "ip_address")
	private String ipAddress;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pc pc = (Pc) o;
		return id.equals(pc.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}