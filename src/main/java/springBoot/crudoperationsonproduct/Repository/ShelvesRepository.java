package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.Shelves;

@Repository
public interface ShelvesRepository extends JpaRepository<Shelves, Integer> {

        Shelves findByDescription(String description);
}
