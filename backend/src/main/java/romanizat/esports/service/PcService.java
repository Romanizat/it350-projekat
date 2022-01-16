package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface PcService {

	List<Pc> findAll(Specification<Pc> specification);

	Pc save(Pc pc);

	Pc update(Pc pc);

	Pc findById(Integer pcId);

	void deleteById(Integer pcId);

}