package springBoot.crudoperationsonproduct.Service;

import springBoot.crudoperationsonproduct.DTO.ProductDto;
import springBoot.crudoperationsonproduct.Entity.Product;

import java.util.List;

public interface ProductService {


    public List<Product> findAll();
    public Product findById(Integer theId);
    public void deleteProduct(Integer theId);
    ProductDto saveProduct(ProductDto product) ;
    void updateProduct(ProductDto productDto);
    Product findByBarcode(String barcode);
    List<Product> findByDescription(String description);



}
