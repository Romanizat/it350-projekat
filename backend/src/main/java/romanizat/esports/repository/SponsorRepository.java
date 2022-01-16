package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Integer>, JpaSpecificationExecutor<Sponsor> {

}