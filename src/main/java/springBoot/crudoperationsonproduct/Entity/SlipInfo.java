package springBoot.crudoperationsonproduct.Entity;

import springBoot.crudoperationsonproduct.DTO.SlipInfoDTO;

import javax.persistence.*;

@Entity
@Table(name = "slipinfo")
public class SlipInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelves shelves;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "slip_id")
    private Slip slip;


    public SlipInfo() {
    }


    public SlipInfo(SlipInfoDTO slipInfoDTO)
    {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shelves getShelves() {
        return shelves;
    }

    public void setShelves(Shelves shelves) {
        this.shelves = shelves;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Slip getSlip() {
        return slip;
    }

    public void setSlip(Slip slip) {
        this.slip = slip;
    }
}
