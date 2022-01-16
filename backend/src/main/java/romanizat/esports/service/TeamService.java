package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface TeamService {

	List<Team> findAll(Specification<Team> specification);

	Team save(Team team);

	Team update(Team team);

	Team findById(Integer teamId);

	void deleteById(Integer teamId);

}