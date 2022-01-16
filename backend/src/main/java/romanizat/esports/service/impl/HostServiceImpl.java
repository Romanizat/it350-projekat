package romanizat.esports.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import romanizat.esports.entity.*;
import romanizat.esports.repository.HostRepository;
import romanizat.esports.service.HostService;

@Service
@RequiredArgsConstructor
public class HostServiceImpl implements HostService {
	private final HostRepository hostRepository;

	@Override
	public List<Host> findAll(Specification<Host> specification) {
		return hostRepository.findAll(specification);
	}

	@Override
	public Host findById(Integer hostId) {
		return hostRepository.findById(hostId)
				.orElseThrow(() -> new NoSuchElementException("HostService.notFound"));
	}

	@Override
	public Host save(Host host) {
		return hostRepository.save(host);
	}

	@Override
	public Host update(Host host) {
		return hostRepository.save(host);
	}

	@Override
	public void deleteById(Integer hostId) {
		hostRepository.deleteById(hostId);
	}


}