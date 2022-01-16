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
@RequestMapping("/arenas")
@RequiredArgsConstructor
public class ArenaController {
	private final ArenaService arenaService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllArenas")
	public ResponseEntity<List<Arena>> getAllArenas(@RequestParam(name = "q", required = false) Specification<Arena> specification) {
		return ResponseEntity.ok(arenaService.findAll(specification));
	}

	@GetMapping("/{arenaId}")
	@ApiOperation(value = "", nickname = "getArenaById")
	public ResponseEntity<Arena> getArenaById(@PathVariable Integer arenaId) {
		return ResponseEntity.ok(arenaService.findById(arenaId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveArena")
	public ResponseEntity<Arena> saveArena(@RequestBody Arena arena) {
		return ResponseEntity.status(HttpStatus.CREATED).body(arenaService.save(arena));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateArena")
	public ResponseEntity<Arena> updateArena(@RequestBody Arena arena) {
		return ResponseEntity.ok(arenaService.update(arena));
	}

	@DeleteMapping("/{arenaId}")
	@ApiOperation(value = "", nickname = "deleteArenaById")
	public void deleteArenaById(@PathVariable Integer arenaId) {
		arenaService.deleteById(arenaId);
	}

}

