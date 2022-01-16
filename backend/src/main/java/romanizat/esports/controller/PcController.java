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
@RequestMapping("/pcs")
@RequiredArgsConstructor
public class PcController {
	private final PcService pcService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllPcs")
	public ResponseEntity<List<Pc>> getAllPcs(@RequestParam(name = "q", required = false) Specification<Pc> specification) {
		return ResponseEntity.ok(pcService.findAll(specification));
	}

	@GetMapping("/{pcId}")
	@ApiOperation(value = "", nickname = "getPcById")
	public ResponseEntity<Pc> getPcById(@PathVariable Integer pcId) {
		return ResponseEntity.ok(pcService.findById(pcId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "savePc")
	public ResponseEntity<Pc> savePc(@RequestBody Pc pc) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pcService.save(pc));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updatePc")
	public ResponseEntity<Pc> updatePc(@RequestBody Pc pc) {
		return ResponseEntity.ok(pcService.update(pc));
	}

	@DeleteMapping("/{pcId}")
	@ApiOperation(value = "", nickname = "deletePcById")
	public void deletePcById(@PathVariable Integer pcId) {
		pcService.deleteById(pcId);
	}

}

