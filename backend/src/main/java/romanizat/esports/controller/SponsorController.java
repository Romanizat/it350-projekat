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
@RequestMapping("/sponsors")
@RequiredArgsConstructor
public class SponsorController {
	private final SponsorService sponsorService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllSponsors")
	public ResponseEntity<List<Sponsor>> getAllSponsors(@RequestParam(name = "q", required = false) Specification<Sponsor> specification) {
		return ResponseEntity.ok(sponsorService.findAll(specification));
	}

	@GetMapping("/{sponsorId}")
	@ApiOperation(value = "", nickname = "getSponsorById")
	public ResponseEntity<Sponsor> getSponsorById(@PathVariable Integer sponsorId) {
		return ResponseEntity.ok(sponsorService.findById(sponsorId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveSponsor")
	public ResponseEntity<Sponsor> saveSponsor(@RequestBody Sponsor sponsor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(sponsorService.save(sponsor));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateSponsor")
	public ResponseEntity<Sponsor> updateSponsor(@RequestBody Sponsor sponsor) {
		return ResponseEntity.ok(sponsorService.update(sponsor));
	}

	@DeleteMapping("/{sponsorId}")
	@ApiOperation(value = "", nickname = "deleteSponsorById")
	public void deleteSponsorById(@PathVariable Integer sponsorId) {
		sponsorService.deleteById(sponsorId);
	}

}

