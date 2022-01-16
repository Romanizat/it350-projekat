package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface ArenaService {

	List<Arena> findAll(Specification<Arena> specification);

	Arena save(Arena arena);

	Arena update(Arena arena);

	Arena findById(Integer arenaId);

	void deleteById(Integer arenaId);

}