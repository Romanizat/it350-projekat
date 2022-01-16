package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.GenreRepository;
import romanizat.esports.service.GenreService;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
	private final GenreRepository genreRepository;

	@Override
	public List<Genre> findAll(Specification<Genre> specification) {
		return genreRepository.findAll(specification);
	}

	@Override
	public Genre findById(Integer genreId) {
		return genreRepository.findById(genreId)
				.orElseThrow(() -> new NoSuchElementException("GenreService.notFound"));
	}

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public Genre update(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public void deleteById(Integer genreId) {
		genreRepository.deleteById(genreId);
	}


}