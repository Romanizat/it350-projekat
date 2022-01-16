package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.SponsorRepository;
import romanizat.esports.service.SponsorService;

@Service
@RequiredArgsConstructor
public class SponsorServiceImpl implements SponsorService {
	private final SponsorRepository sponsorRepository;

	@Override
	public List<Sponsor> findAll(Specification<Sponsor> specification) {
		return sponsorRepository.findAll(specification);
	}

	@Override
	public Sponsor findById(Integer sponsorId) {
		return sponsorRepository.findById(sponsorId)
				.orElseThrow(() -> new NoSuchElementException("SponsorService.notFound"));
	}

	@Override
	public Sponsor save(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

	@Override
	public Sponsor update(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

	@Override
	public void deleteById(Integer sponsorId) {
		sponsorRepository.deleteById(sponsorId);
	}


}