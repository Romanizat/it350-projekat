package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface GameService {

	List<Game> findAll(Specification<Game> specification);

	List<Game> findAll();

	Game save(Game game);

	Game update(Game game);

	Game findById(Integer gameId);

	void deleteById(Integer gameId);

}