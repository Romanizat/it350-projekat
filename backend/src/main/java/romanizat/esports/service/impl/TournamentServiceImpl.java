package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.TournamentRepository;
import romanizat.esports.service.TournamentService;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {
	private final TournamentRepository tournamentRepository;

	@Override
	public List<Tournament> findAll(Specification<Tournament> specification) {
		return tournamentRepository.findAll(specification);
	}

	@Override
	public Tournament findById(Integer tournamentId) {
		return tournamentRepository.findById(tournamentId)
				.orElseThrow(() -> new NoSuchElementException("TournamentService.notFound"));
	}

	@Override
	public Tournament save(Tournament tournament) {
		return tournamentRepository.save(tournament);
	}

	@Override
	public Tournament update(Tournament tournament) {
		return tournamentRepository.save(tournament);
	}

	@Override
	public void deleteById(Integer tournamentId) {
		tournamentRepository.deleteById(tournamentId);
	}


}