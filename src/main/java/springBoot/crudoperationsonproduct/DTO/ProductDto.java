package springBoot.crudoperationsonproduct.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springBoot.crudoperationsonproduct.Entity.Product;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto{

    private Integer id;


    private String description;


    private String barcode;


    private String metric;



    public ProductDto(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.barcode = product.getBarcode();
        this.metric = product.getMetric();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
