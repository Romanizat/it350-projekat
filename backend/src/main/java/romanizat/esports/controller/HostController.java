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
@RequestMapping("/hosts")
@RequiredArgsConstructor
public class HostController {
	private final HostService hostService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllHosts")
	public ResponseEntity<List<Host>> getAllHosts(@RequestParam(name = "q", required = false) Specification<Host> specification) {
		return ResponseEntity.ok(hostService.findAll(specification));
	}

	@GetMapping("/{hostId}")
	@ApiOperation(value = "", nickname = "getHostById")
	public ResponseEntity<Host> getHostById(@PathVariable Integer hostId) {
		return ResponseEntity.ok(hostService.findById(hostId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveHost")
	public ResponseEntity<Host> saveHost(@RequestBody Host host) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hostService.save(host));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateHost")
	public ResponseEntity<Host> updateHost(@RequestBody Host host) {
		return ResponseEntity.ok(hostService.update(host));
	}

	@DeleteMapping("/{hostId}")
	@ApiOperation(value = "", nickname = "deleteHostById")
	public void deleteHostById(@PathVariable Integer hostId) {
		hostService.deleteById(hostId);
	}

}

