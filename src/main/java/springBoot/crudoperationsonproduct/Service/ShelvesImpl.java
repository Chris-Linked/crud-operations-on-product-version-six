package springBoot.crudoperationsonproduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.crudoperationsonproduct.DTO.ShelvesDto;
import springBoot.crudoperationsonproduct.Entity.Shelves;
import springBoot.crudoperationsonproduct.Entity.Warehouse;
import springBoot.crudoperationsonproduct.Exceptsions.ResourceNotFoundException;
import springBoot.crudoperationsonproduct.Repository.ShelvesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShelvesImpl implements ShelvesService{

    @Autowired
    ShelvesRepository shelvesRepository;

    @Autowired
    WarehouseService warehouseService;

    @Override
    public List<Shelves> findAll() {
        List<Shelves> list = new ArrayList<>();
        list = shelvesRepository.findAll();
        if(list.isEmpty())
        {
            throw new ResourceNotFoundException("list is empty");
        }else {
            return list;
        }

    }


    @Override
    public ShelvesDto save(ShelvesDto shelvesDto) {

        if(shelvesDto == null)
        {
            throw new ResourceNotFoundException("the entity cannot be null");
        }
        Shelves shelves1 = new Shelves();
        Warehouse warehouse = warehouseService.findById(shelvesDto.getWarehouseId());
        if(warehouse == null)
        {
            throw new ResourceNotFoundException("warehouse with id " + shelvesDto.getWarehouseId() +
                     " not found");
        }else if(shelvesDto.getDescription() == null)
        {
            throw new ResourceNotFoundException("Description cannot be null");
        }else
        {
            shelves1.setDescription(shelvesDto.getDescription());


            shelves1.setWarehouse(warehouse);

            shelves1 = shelvesRepository.save(shelves1);
            return new ShelvesDto(shelves1);
        }



    }

    @Override
    public Shelves findById(Integer theId){
        //return  shelvesRepository.findById(theId).orElseThrow(Exception::new);
        if(findByIdp(theId))
        {
            Optional<Shelves> shelves  = shelvesRepository.findById(theId);
            Shelves shelves1 = null;
            if(shelves.isPresent())
            {
                shelves1 = shelves.get();

            }
            return shelves1;
        }else
        {
            throw new ResourceNotFoundException("id " + theId +  " was not found");
        }

    }

    @Override
    public Shelves findByDescription(String description) {

        List<Shelves> list = shelvesRepository.findAll();

        for(Shelves shelves : list)
        {
            if(shelves.getDescription().equals(description))
            {
                return shelves;
            }else
            {
                throw new ResourceNotFoundException("description was not found");
            }

        }

        return null;
    }

    @Override
    public void deleteShelve(Shelves shelves)
    {
        if(shelves == null)
        {
            throw new ResourceNotFoundException("shelves cannot be null");
        }
        shelvesRepository.delete(shelves);
    }

    @Override
    public void updateShelve(ShelvesDto shelvesDto) {

        Warehouse warehouse = warehouseService.findById(shelvesDto.getWarehouseId());

        Shelves shelves = findById(shelvesDto.getId());
        if(!shelves.getDescription().equals(shelvesDto))
        {
            shelves.setDescription(shelvesDto.getDescription());
            shelves.setWarehouse(warehouse);
            shelvesRepository.save(shelves);
        }else{
            throw new ResourceNotFoundException("something is wrong");
        }

    }

    private boolean findByIdp( Integer theId)
    {
        List<Shelves> shelves = findAll();
        for(Shelves shelves1 : shelves)
        {
            if(shelves1.getId() == theId)
                return true;
        }
        return false;
    }

}
