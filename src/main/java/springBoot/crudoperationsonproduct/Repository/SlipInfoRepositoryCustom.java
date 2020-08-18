package springBoot.crudoperationsonproduct.Repository;

import springBoot.crudoperationsonproduct.Entity.Product;
import springBoot.crudoperationsonproduct.Entity.Warehouse;
import springBoot.crudoperationsonproduct.Projection.Test;

import java.util.List;

public interface SlipInfoRepositoryCustom {

    List<Product> findProductByBarcode(String barcode);
    List<Test> findProduct(String barcode, String description, String shelf);
    Warehouse findWarehouseByDescription(String description1);
    Product findByBarcode(String barcode);
    List<Test> findWarAndMore(String barcode, String warehouse, String shelf);
}
