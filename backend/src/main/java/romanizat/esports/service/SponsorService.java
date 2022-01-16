package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface SponsorService {

	List<Sponsor> findAll(Specification<Sponsor> specification);

	Sponsor save(Sponsor sponsor);

	Sponsor update(Sponsor sponsor);

	Sponsor findById(Integer sponsorId);

	void deleteById(Integer sponsorId);

}