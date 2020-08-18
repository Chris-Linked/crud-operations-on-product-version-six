package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.Slip;

@Repository
public interface SlipRepository extends JpaRepository<Slip, Integer> {



}
