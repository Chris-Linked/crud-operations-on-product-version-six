package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot.crudoperationsonproduct.Entity.SlipInfo;

public interface SlipInfoRepository extends JpaRepository<SlipInfo, Integer> {
}
