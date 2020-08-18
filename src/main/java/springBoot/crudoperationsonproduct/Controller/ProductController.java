package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBoot.crudoperationsonproduct.DTO.ProductDto;
import springBoot.crudoperationsonproduct.Entity.Product;
import springBoot.crudoperationsonproduct.Repository.SlipInfoRepositoryCustom;
import springBoot.crudoperationsonproduct.Service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SlipInfoRepositoryCustom slipInfoRepositoryCustom;

    @GetMapping("/productwith/{barcode}")
    public Product productWithBarcode(@PathVariable String barcode)
    {
        return slipInfoRepositoryCustom.findByBarcode(barcode);
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public ProductDto getProduct(@PathVariable Integer productId) {

            Product product =  productService.findById(productId);

            ProductDto productDto = new ProductDto(product);
            return productDto;


    }

    @GetMapping("/product/{barcode}")
    public ProductDto getByBarcode(@PathVariable String barcode)  {
        Product product = productService.findByBarcode(barcode);
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    @GetMapping("/productd/{description}")
    public List<ProductDto> getByDescritpion(@PathVariable String description) {


        List<Product> products = productService.findByDescription(description);

        List<ProductDto> list = new ArrayList<>();

        for(Product pro : products)
        {
            list.add(new ProductDto(pro));
        }
        return list;

    }


    @PostMapping("/saveProduct")
    public ProductDto saveNew(@RequestBody ProductDto product) throws Exception {

        return productService.saveProduct(product);

    }

    @DeleteMapping("/delete/{theId}")
    public void deletePro(@PathVariable Integer theId){
        productService.deleteProduct(theId);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
    }


}
