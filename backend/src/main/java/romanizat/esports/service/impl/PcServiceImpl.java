package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.PcRepository;
import romanizat.esports.service.PcService;

@Service
@RequiredArgsConstructor
public class PcServiceImpl implements PcService {
	private final PcRepository pcRepository;

	@Override
	public List<Pc> findAll(Specification<Pc> specification) {
		return pcRepository.findAll(specification);
	}

	@Override
	public Pc findById(Integer pcId) {
		return pcRepository.findById(pcId)
				.orElseThrow(() -> new NoSuchElementException("PcService.notFound"));
	}

	@Override
	public Pc save(Pc pc) {
		return pcRepository.save(pc);
	}

	@Override
	public Pc update(Pc pc) {
		return pcRepository.save(pc);
	}

	@Override
	public void deleteById(Integer pcId) {
		pcRepository.deleteById(pcId);
	}


}