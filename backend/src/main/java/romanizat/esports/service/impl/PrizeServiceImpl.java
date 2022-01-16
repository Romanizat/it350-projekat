package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.PrizeRepository;
import romanizat.esports.service.PrizeService;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {
	private final PrizeRepository prizeRepository;

	@Override
	public List<Prize> findAll(Specification<Prize> specification) {
		return prizeRepository.findAll(specification);
	}

	@Override
	public Prize findById(Integer prizeId) {
		return prizeRepository.findById(prizeId)
				.orElseThrow(() -> new NoSuchElementException("PrizeService.notFound"));
	}

	@Override
	public Prize save(Prize prize) {
		return prizeRepository.save(prize);
	}

	@Override
	public Prize update(Prize prize) {
		return prizeRepository.save(prize);
	}

	@Override
	public void deleteById(Integer prizeId) {
		prizeRepository.deleteById(prizeId);
	}


}