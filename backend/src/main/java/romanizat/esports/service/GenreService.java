package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface GenreService {

	List<Genre> findAll(Specification<Genre> specification);

	Genre save(Genre genre);

	Genre update(Genre genre);

	Genre findById(Integer genreId);

	void deleteById(Integer genreId);

}