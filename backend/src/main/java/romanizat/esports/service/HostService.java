package romanizat.esports.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import romanizat.esports.entity.*;

public interface HostService {

	List<Host> findAll(Specification<Host> specification);

	Host save(Host host);

	Host update(Host host);

	Host findById(Integer hostId);

	void deleteById(Integer hostId);

}