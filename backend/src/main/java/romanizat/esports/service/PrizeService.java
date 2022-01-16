package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface PrizeService {

	List<Prize> findAll(Specification<Prize> specification);

	Prize save(Prize prize);

	Prize update(Prize prize);

	Prize findById(Integer prizeId);

	void deleteById(Integer prizeId);

}