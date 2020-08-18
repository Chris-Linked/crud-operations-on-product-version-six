package springBoot.crudoperationsonproduct.Service;

import springBoot.crudoperationsonproduct.DTO.SlipDTO;
import springBoot.crudoperationsonproduct.Entity.Slip;

import java.util.List;

public interface SlipService {

    List<Slip> findAll();
    Slip findById(Integer theId);
    SlipDTO save(SlipDTO slipDTO);
    void delete(Integer theId);

}
