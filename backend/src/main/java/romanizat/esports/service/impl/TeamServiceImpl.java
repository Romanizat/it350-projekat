package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.TeamRepository;
import romanizat.esports.service.TeamService;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
	private final TeamRepository teamRepository;

	@Override
	public List<Team> findAll(Specification<Team> specification) {
		return teamRepository.findAll(specification);
	}

	@Override
	public Team findById(Integer teamId) {
		return teamRepository.findById(teamId)
				.orElseThrow(() -> new NoSuchElementException("TeamService.notFound"));
	}

	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public Team update(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public void deleteById(Integer teamId) {
		teamRepository.deleteById(teamId);
	}


}