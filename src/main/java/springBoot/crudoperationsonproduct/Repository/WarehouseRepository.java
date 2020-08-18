package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.Warehouse;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    List<Warehouse> findAll();
    List<Warehouse> findByDescription(String description);
}
