package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.ArenaRepository;
import romanizat.esports.service.ArenaService;

@Service
@RequiredArgsConstructor
public class ArenaServiceImpl implements ArenaService {
	private final ArenaRepository arenaRepository;

	@Override
	public List<Arena> findAll(Specification<Arena> specification) {
		return arenaRepository.findAll(specification);
	}

	@Override
	public Arena findById(Integer arenaId) {
		return arenaRepository.findById(arenaId)
				.orElseThrow(() -> new NoSuchElementException("ArenaService.notFound"));
	}

	@Override
	public Arena save(Arena arena) {
		return arenaRepository.save(arena);
	}

	@Override
	public Arena update(Arena arena) {
		return arenaRepository.save(arena);
	}

	@Override
	public void deleteById(Integer arenaId) {
		arenaRepository.deleteById(arenaId);
	}


}