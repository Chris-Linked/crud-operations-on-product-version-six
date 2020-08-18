package springBoot.crudoperationsonproduct.Service;

import springBoot.crudoperationsonproduct.DTO.ShelvesDto;
import springBoot.crudoperationsonproduct.Entity.Shelves;

import java.util.List;

public interface ShelvesService {
    List<Shelves> findAll();
    ShelvesDto save(ShelvesDto shelvesDto);
    Shelves findById(Integer theId);
    Shelves findByDescription(String description);
    void deleteShelve(Shelves shelves);
    void updateShelve(ShelvesDto shelvesDto);
}
