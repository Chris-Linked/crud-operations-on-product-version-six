package springBoot.crudoperationsonproduct.Entity;

import springBoot.crudoperationsonproduct.DTO.ShelvesDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelves")
public class Shelves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToMany(mappedBy = "shelves")
    private List<SlipInfo> slipInfo;


    public Shelves() {
    }

    public Shelves(ShelvesDto shelvesDto)
    {
        this.id = shelvesDto.getId();
        this.description = shelvesDto.getDescription();

    }

    public Shelves(String description, Warehouse warehouse) {

        this.description = description;
        this.warehouse = warehouse;
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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<SlipInfo> getSlipInfo() {
        return slipInfo;
    }

    public void setSlipInfo(List<SlipInfo> slipInfo) {
        this.slipInfo = slipInfo;
    }
}
