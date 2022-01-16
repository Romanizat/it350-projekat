package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.TournamentPrize;

@Repository
public interface TournamentPrizeRepository extends JpaRepository<TournamentPrize, Integer>, JpaSpecificationExecutor<TournamentPrize> {

}