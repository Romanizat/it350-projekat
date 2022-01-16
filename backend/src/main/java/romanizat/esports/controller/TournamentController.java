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
@RequestMapping("/tournaments")
@RequiredArgsConstructor
public class TournamentController {
	private final TournamentService tournamentService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTournaments")
	public ResponseEntity<List<Tournament>> getAllTournaments(@RequestParam(name = "q", required = false) Specification<Tournament> specification) {
		return ResponseEntity.ok(tournamentService.findAll(specification));
	}

	@GetMapping("/{tournamentId}")
	@ApiOperation(value = "", nickname = "getTournamentById")
	public ResponseEntity<Tournament> getTournamentById(@PathVariable Integer tournamentId) {
		return ResponseEntity.ok(tournamentService.findById(tournamentId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveTournament")
	public ResponseEntity<Tournament> saveTournament(@RequestBody Tournament tournament) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.save(tournament));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateTournament")
	public ResponseEntity<Tournament> updateTournament(@RequestBody Tournament tournament) {
		return ResponseEntity.ok(tournamentService.update(tournament));
	}

	@DeleteMapping("/{tournamentId}")
	@ApiOperation(value = "", nickname = "deleteTournamentById")
	public void deleteTournamentById(@PathVariable Integer tournamentId) {
		tournamentService.deleteById(tournamentId);
	}

}

