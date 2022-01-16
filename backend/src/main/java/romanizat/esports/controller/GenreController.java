package romanizat.esports.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import romanizat.esports.entity.*;
import romanizat.esports.service.*;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {
	private final GenreService genreService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllGenres")
	public ResponseEntity<List<Genre>> getAllGenres(@RequestParam(name = "q", required = false) Specification<Genre> specification) {
		return ResponseEntity.ok(genreService.findAll(specification));
	}

	@GetMapping("/{genreId}")
	@ApiOperation(value = "", nickname = "getGenreById")
	public ResponseEntity<Genre> getGenreById(@PathVariable Integer genreId) {
		return ResponseEntity.ok(genreService.findById(genreId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveGenre")
	public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre) {
		return ResponseEntity.status(HttpStatus.CREATED).body(genreService.save(genre));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateGenre")
	public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre) {
		return ResponseEntity.ok(genreService.update(genre));
	}

	@DeleteMapping("/{genreId}")
	@ApiOperation(value = "", nickname = "deleteGenreById")
	public void deleteGenreById(@PathVariable Integer genreId) {
		genreService.deleteById(genreId);
	}

}

