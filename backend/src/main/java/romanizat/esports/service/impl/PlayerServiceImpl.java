package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.PlayerRepository;
import romanizat.esports.service.PlayerService;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
	private final PlayerRepository playerRepository;

	@Override
	public List<Player> findAll(Specification<Player> specification) {
		return playerRepository.findAll(specification);
	}

	@Override
	public Player findById(Integer playerId) {
		return playerRepository.findById(playerId)
				.orElseThrow(() -> new NoSuchElementException("PlayerService.notFound"));
	}

	@Override
	public Player save(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player update(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public void deleteById(Integer playerId) {
		playerRepository.deleteById(playerId);
	}


}