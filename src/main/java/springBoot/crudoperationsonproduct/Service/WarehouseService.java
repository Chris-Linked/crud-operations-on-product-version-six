package springBoot.crudoperationsonproduct.Service;

import springBoot.crudoperationsonproduct.DTO.WarehouseDto;
import springBoot.crudoperationsonproduct.Entity.Warehouse;

import java.util.List;


public interface WarehouseService {
    List<Warehouse> findAll();
    Warehouse findById(Integer id);
    void deleteWarehouse(Integer id);
    void updateWarehouse(WarehouseDto warehouseDto);
    Warehouse save(WarehouseDto warehouseDto);
    List<Warehouse> findByDescription(String description);
}
