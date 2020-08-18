package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByBarcode(String barcode);
    List<Product> findByDescription(String description);


}
