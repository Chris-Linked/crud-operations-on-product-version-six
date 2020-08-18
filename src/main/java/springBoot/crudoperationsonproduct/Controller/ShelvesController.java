package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBoot.crudoperationsonproduct.DTO.ShelvesDto;
import springBoot.crudoperationsonproduct.Entity.Shelves;
import springBoot.crudoperationsonproduct.Exceptsions.BadRequestException;
import springBoot.crudoperationsonproduct.Repository.WarehouseRepository;
import springBoot.crudoperationsonproduct.Service.ShelvesService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/she")
public class ShelvesController {

    @Autowired
    private ShelvesService shelvesService;

    @Autowired
    private WarehouseRepository warehouseRepository;


    @GetMapping("/shelves")
    public List<ShelvesDto> findAll() throws BadRequestException
    {
        List<Shelves> list = shelvesService.findAll();

        List<ShelvesDto> list1 = new ArrayList<>();

        for(Shelves shelves : list)
        {
            list1.add(new ShelvesDto(shelves));
        }
        return list1;
    }

    @GetMapping("/shelves/{description}")
    public ShelvesDto findByDescription(@PathVariable String description)
    {
       return new ShelvesDto(shelvesService.findByDescription(description));
    }


    @GetMapping("/shelve/{theId}")
    public ShelvesDto findById(@PathVariable Integer theId){
        return new ShelvesDto(shelvesService.findById(theId));
    }
    @PostMapping("/shelve")
    public ShelvesDto saveShelve(@RequestBody ShelvesDto shelvesDto) {
        if(shelvesDto.getWarehouseId() == null)
        {
            throw new BadRequestException("warehouse id cannot be null!");
        }
        return shelvesService.save(shelvesDto);

    }

    @PutMapping("/shelve")
    public void updateShelve(@RequestBody ShelvesDto shelvesDto)
    {
            shelvesService.updateShelve(shelvesDto);
    }

    @DeleteMapping("/shelve/{theId}")
    public void delete(@PathVariable Integer theId)
    {
        Shelves shelves = shelvesService.findById(theId);
        shelvesService.deleteShelve(shelves);
    }
}