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
@RequestMapping("/prizes")
@RequiredArgsConstructor
public class PrizeController {
	private final PrizeService prizeService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllPrizes")
	public ResponseEntity<List<Prize>> getAllPrizes(@RequestParam(name = "q", required = false) Specification<Prize> specification) {
		return ResponseEntity.ok(prizeService.findAll(specification));
	}

	@GetMapping("/{prizeId}")
	@ApiOperation(value = "", nickname = "getPrizeById")
	public ResponseEntity<Prize> getPrizeById(@PathVariable Integer prizeId) {
		return ResponseEntity.ok(prizeService.findById(prizeId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "savePrize")
	public ResponseEntity<Prize> savePrize(@RequestBody Prize prize) {
		return ResponseEntity.status(HttpStatus.CREATED).body(prizeService.save(prize));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updatePrize")
	public ResponseEntity<Prize> updatePrize(@RequestBody Prize prize) {
		return ResponseEntity.ok(prizeService.update(prize));
	}

	@DeleteMapping("/{prizeId}")
	@ApiOperation(value = "", nickname = "deletePrizeById")
	public void deletePrizeById(@PathVariable Integer prizeId) {
		prizeService.deleteById(prizeId);
	}

}

