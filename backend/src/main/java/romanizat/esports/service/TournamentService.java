package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface TournamentService {

	List<Tournament> findAll(Specification<Tournament> specification);

	Tournament save(Tournament tournament);

	Tournament update(Tournament tournament);

	Tournament findById(Integer tournamentId);

	void deleteById(Integer tournamentId);

}