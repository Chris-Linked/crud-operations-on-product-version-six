package springBoot.crudoperationsonproduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.crudoperationsonproduct.DTO.WarehouseDto;
import springBoot.crudoperationsonproduct.Entity.Warehouse;
import springBoot.crudoperationsonproduct.Exceptsions.BadRequestException;
import springBoot.crudoperationsonproduct.Exceptsions.ResourceNotFoundException;
import springBoot.crudoperationsonproduct.Repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseImpl implements WarehouseService{

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> findAll() {

        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findById(Integer id) {

      return  warehouseRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("warehouse was not found with id " + id));
    }

    @Override
    public void deleteWarehouse(Integer id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("warehouse was not found with id " + id));
        warehouseRepository.delete(warehouse);
    }

    @Override
    public void updateWarehouse(WarehouseDto warehouseDto) {
        Warehouse warehouse = new Warehouse(warehouseDto);
        if(warehouse == null)
        {
            throw new ResourceNotFoundException("warehouse was not found");
        }else {
            warehouseRepository.save(warehouse);
        }
    }

    @Override
    public Warehouse save(WarehouseDto warehouseDto) {
        Warehouse warehouse = new Warehouse(warehouseDto);
        return warehouseRepository.save(warehouse);

    }

    @Override
    public List<Warehouse> findByDescription(String description) {
        List<Warehouse> warehouses = warehouseRepository.findByDescription(description);

        if(findByDesc(warehouses, description))
        {
            return warehouses;
        }else if(!findByDesc(warehouses, description))
        {
            throw new ResourceNotFoundException("warehouse with description " + description + " was not found");
        }else{
            throw new BadRequestException("bad request please try again");
        }

    }

    private boolean findByDesc(List<Warehouse> list, String description)
    {
        for(Warehouse warehouse : list)
        {
            if(warehouse.getDescription().equals(description))
                return true;
        }
        return false;
    }
}
