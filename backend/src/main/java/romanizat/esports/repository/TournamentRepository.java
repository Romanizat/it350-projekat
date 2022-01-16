package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer>, JpaSpecificationExecutor<Tournament> {

}