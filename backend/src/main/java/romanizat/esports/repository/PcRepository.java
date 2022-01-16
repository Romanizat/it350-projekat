package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Pc;

@Repository
public interface PcRepository extends JpaRepository<Pc, Integer>, JpaSpecificationExecutor<Pc> {

}