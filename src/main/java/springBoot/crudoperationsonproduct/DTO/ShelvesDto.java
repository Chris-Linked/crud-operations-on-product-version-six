package springBoot.crudoperationsonproduct.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springBoot.crudoperationsonproduct.Entity.Shelves;

@Getter
@Setter
@NoArgsConstructor
public class ShelvesDto {

    private Integer id;

    private String description;

    private Integer warehouseId;

    private String warehouseDesc;


    public ShelvesDto(Shelves shelves)
    {
        this.id = shelves.getId();

        this.description = shelves.getDescription();
        if(shelves.getWarehouse() != null) {
            this.warehouseId = shelves.getWarehouse().getId();
            this.warehouseDesc = shelves.getWarehouse().getDescription();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseDesc() {
        return warehouseDesc;
    }

    public void setWarehouseDesc(String warehouseDesc) {
        this.warehouseDesc = warehouseDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

