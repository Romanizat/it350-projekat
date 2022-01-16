package romanizat.esports.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import romanizat.esports.entity.Prize;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Integer>, JpaSpecificationExecutor<Prize> {

}