package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.TournamentPrizeRepository;
import romanizat.esports.service.TournamentPrizeService;


@Service
@RequiredArgsConstructor
public class TournamentPrizeServiceImpl implements TournamentPrizeService {
	private final TournamentPrizeRepository tournamentPrizeRepository;

	@Override
	public List<TournamentPrize> findAll(Specification<TournamentPrize> specification) {
		return tournamentPrizeRepository.findAll(specification);
	}

	@Override
	public TournamentPrize findById(Integer tournamentPrizeId) {
		return tournamentPrizeRepository.findById(tournamentPrizeId)
				.orElseThrow(() -> new NoSuchElementException("TournamentPrizeService.notFound"));
	}

	@Override
	public TournamentPrize save(TournamentPrize tournamentPrize) {
		return tournamentPrizeRepository.save(tournamentPrize);
	}

	@Override
	public TournamentPrize update(TournamentPrize tournamentPrize) {
		return tournamentPrizeRepository.save(tournamentPrize);
	}

	@Override
	public void deleteById(Integer tournamentPrizeId) {
		tournamentPrizeRepository.deleteById(tournamentPrizeId);
	}


}