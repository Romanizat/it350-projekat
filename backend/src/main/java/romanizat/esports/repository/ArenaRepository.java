package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Arena;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Integer>, JpaSpecificationExecutor<Arena> {

}