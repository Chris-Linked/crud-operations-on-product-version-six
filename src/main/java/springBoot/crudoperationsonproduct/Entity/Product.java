package springBoot.crudoperationsonproduct.Entity;

import springBoot.crudoperationsonproduct.DTO.ProductDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;


    // barcode
    @Column(name = "barcode")
    private String barcode;

    // monada metrisis
    @Column(name = "metric")
    private String metric;

    @OneToMany(mappedBy = "product")
    private List<SlipInfo> slipInfos;


    public Product() {
    }

    public Product(String description, String barcode, String metric, Date date) {
        this.description = description;
        this.barcode = barcode;
        this.metric = metric;

    }

    public Product(ProductDto productDto)
    {
        this.id = productDto.getId();
        this.description = productDto.getDescription();
        this.barcode = productDto.getBarcode();
        this.metric = productDto.getMetric();
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

    public List<SlipInfo> getSlipInfos() {
        return slipInfos;
    }

    public void setSlipInfos(List<SlipInfo> slipInfos) {
        this.slipInfos = slipInfos;
    }
}
