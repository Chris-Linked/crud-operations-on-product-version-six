package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBoot.crudoperationsonproduct.DTO.WarehouseDto;
import springBoot.crudoperationsonproduct.Entity.Warehouse;
import springBoot.crudoperationsonproduct.Repository.SlipInfoRepositoryCustom;
import springBoot.crudoperationsonproduct.Service.WarehouseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/war")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    private SlipInfoRepositoryCustom slipInfoRepositoryCustom;

    @GetMapping("/warehousebydescription/{description}")
    public Warehouse findWerehouse(@PathVariable String description)
    {
        return slipInfoRepositoryCustom.findWarehouseByDescription(description);
    }

    @GetMapping("/warehouses")
    public List<WarehouseDto> findAll()
    {
        List<Warehouse> list =  warehouseService.findAll();

        List<WarehouseDto> list1 = new ArrayList<>();

        for(Warehouse warehouse : list)
        {
            list1.add(new WarehouseDto(warehouse));
        }

        return list1;
    }

    @GetMapping("/warehouse/{theId}")
    public WarehouseDto findById(@PathVariable Integer theId)
    {
        return new WarehouseDto( warehouseService.findById(theId));

    }

    @GetMapping("/warehousesd/{description}")
    public List<WarehouseDto> findByDesc(@PathVariable String description)
    {
        List<Warehouse> warehouses = warehouseService.findByDescription(description);
        List<WarehouseDto> warehouseDtos = new ArrayList<>();

        for( Warehouse warehouse : warehouses)
        {
            warehouseDtos.add(new WarehouseDto(warehouse));
        }

        return warehouseDtos;
    }

    @PostMapping("/warehouse")
    public WarehouseDto saveWarehouse(@RequestBody WarehouseDto warehouseDto)
    {
        return new WarehouseDto(warehouseService.save(warehouseDto));
    }

    @DeleteMapping("/warehousede/{theId}")
    public void deleteWarehouse(@PathVariable int theId)
    {
        warehouseService.deleteWarehouse(theId);
    }

    @PutMapping("/warehouse")
    public void update(@RequestBody WarehouseDto warehouseDto)
    {
        warehouseService.updateWarehouse(warehouseDto);
    }

}
