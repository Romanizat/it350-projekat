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
@RequestMapping("/tournament-prizes")
@RequiredArgsConstructor
public class TournamentPrizeController {
	private final TournamentPrizeService tournamentPrizeService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTournamentPrizes")
	public ResponseEntity<List<TournamentPrize>> getAllTournamentPrizes(@RequestParam(name = "q", required = false) Specification<TournamentPrize> specification) {
		return ResponseEntity.ok(tournamentPrizeService.findAll(specification));
	}

	@GetMapping("/{tournamentPrizeId}")
	@ApiOperation(value = "", nickname = "getTournamentPrizeById")
	public ResponseEntity<TournamentPrize> getTournamentPrizeById(@PathVariable Integer tournamentPrizeId) {
		return ResponseEntity.ok(tournamentPrizeService.findById(tournamentPrizeId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveTournamentPrize")
	public ResponseEntity<TournamentPrize> saveTournamentPrize(@RequestBody TournamentPrize tournamentPrize) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tournamentPrizeService.save(tournamentPrize));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateTournamentPrize")
	public ResponseEntity<TournamentPrize> updateTournamentPrize(@RequestBody TournamentPrize tournamentPrize) {
		return ResponseEntity.ok(tournamentPrizeService.update(tournamentPrize));
	}

	@DeleteMapping("/{tournamentPrizeId}")
	@ApiOperation(value = "", nickname = "deleteTournamentPrizeById")
	public void deleteTournamentPrizeById(@PathVariable Integer tournamentPrizeId) {
		tournamentPrizeService.deleteById(tournamentPrizeId);
	}

}

