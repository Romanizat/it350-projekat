package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface TournamentPrizeService {

	List<TournamentPrize> findAll(Specification<TournamentPrize> specification);

	TournamentPrize save(TournamentPrize tournamentPrize);

	TournamentPrize update(TournamentPrize tournamentPrize);

	TournamentPrize findById(Integer tournamentPrizeId);

	void deleteById(Integer tournamentPrizeId);

}