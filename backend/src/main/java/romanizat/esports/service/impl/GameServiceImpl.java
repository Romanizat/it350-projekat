package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.GameRepository;
import romanizat.esports.service.GameService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
	private final GameRepository gameRepository;

	@Override
	public List<Game> findAll(Specification<Game> specification) {
		return gameRepository.findAll(specification);
	}

	@Override
	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	@Override
	public Game findById(Integer gameId) {
		return gameRepository.findById(gameId)
				.orElseThrow(() -> new NoSuchElementException("GameService.notFound"));
	}

	@Override
	public Game save(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public Game update(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public void deleteById(Integer gameId) {
		gameRepository.deleteById(gameId);
	}


}