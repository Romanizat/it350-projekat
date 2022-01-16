package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>, JpaSpecificationExecutor<Host> {

}