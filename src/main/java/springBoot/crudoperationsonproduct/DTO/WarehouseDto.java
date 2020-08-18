package springBoot.crudoperationsonproduct.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springBoot.crudoperationsonproduct.Entity.Warehouse;

@Getter
@Setter
@NoArgsConstructor
public class WarehouseDto {

    private Integer id;

    private String description;

    public WarehouseDto(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.description = warehouse.getDescription();
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
}
