package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface PlayerService {

	List<Player> findAll(Specification<Player> specification);

	Player save(Player player);

	Player update(Player player);

	Player findById(Integer playerId);

	void deleteById(Integer playerId);

}