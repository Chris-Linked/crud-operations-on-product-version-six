package springBoot.crudoperationsonproduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.crudoperationsonproduct.DTO.ProductDto;
import springBoot.crudoperationsonproduct.Entity.Product;
import springBoot.crudoperationsonproduct.Exceptsions.BadRequestException;
import springBoot.crudoperationsonproduct.Exceptsions.ResourceNotFoundException;
import springBoot.crudoperationsonproduct.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty())
        {
            throw new ResourceNotFoundException("database is empty");
        }else
        {
            return products;
        }

    }

    @Override
    public Product findById(Integer theId)  {
        Optional<Product> result = productRepository.findById(theId);
        Product product = null;
        if(result.isPresent())
        {
            return product = result.get();
        }else
        {
            throw new ResourceNotFoundException("product with id " + theId + " was not found");
        }
    }

    @Override
    public void deleteProduct(Integer theId) {
        Product product = findById(theId);
        if(product == null)
        {
           throw new ResourceNotFoundException("product with id " + theId + " was not found");
        }else {
            productRepository.delete(product);
        }

    }


    @Override
    public ProductDto saveProduct(ProductDto productDto)  {

        Product product1 = new Product(productDto);
        if(findBarCode(product1.getBarcode()))
        {
            productRepository.save(product1);
        }else
        {
            //throw new ResourceNotFoundException("barcode must be unique ");
            throw new BadRequestException("barcode must be unique");
        }

        return productDto;
    }

    @Override
    public void updateProduct(ProductDto productDto)  {
        Product product = new Product(productDto);

        List<Product> products = productRepository.findAll();
        if(findProduct(products, product))
        {
            productRepository.save(product);
        }else
        {
            throw new ResourceNotFoundException("product with id " + product.getId() + " was not found");
        }

    }

    @Override
    public Product findByBarcode(String barcode){

        Product product = productRepository.findByBarcode(barcode);
        if(product == null)
        {
            throw new  ResourceNotFoundException("product with barcode " + barcode + " was not found");

        }else
        {
            return product;
        }

    }


    @Override
    public List<Product> findByDescription(String description) {

        List<Product> products = productRepository.findByDescription(description);
        if(findDesc(products, description))
        {
            return products;
        }else {
            throw new ResourceNotFoundException("product with description " + description + " was not found");
        }

    }

    //private method to locate a product by its description
    private boolean findDesc(List<Product> products, String description)
    {
        for(Product product : products)
        {
            if(product.getDescription().equals(description))
                return true;
        }
        return false;
    }

    private boolean findProduct(List<Product> list, Product product)
    {
        for(Product product1 : list)
        {
            if(product1.getId() == product.getId())
                return true;
        }
        return false;
    }

    private boolean findBarCode(String barcode)
    {
        List<Product> list = productRepository.findAll();

        for(Product product : list)
        {
            if(product.getBarcode().equals(barcode))
                return false;
        }
        return true;
    }

}
