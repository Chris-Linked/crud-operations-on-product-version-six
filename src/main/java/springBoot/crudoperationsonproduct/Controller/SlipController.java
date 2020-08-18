package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBoot.crudoperationsonproduct.DTO.SlipDTO;
import springBoot.crudoperationsonproduct.Entity.Slip;
import springBoot.crudoperationsonproduct.Service.SlipService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class SlipController {

    @Autowired
    SlipService slipService;

    @GetMapping("/slip")
    public List<SlipDTO> findAll()
    {
        List<Slip> slips = slipService.findAll();
        List<SlipDTO> slipDTOS = new ArrayList<>();

        for(Slip slip : slips)
        {
            slipDTOS.add(new SlipDTO(slip));
        }
        return slipDTOS;
    }

    @GetMapping("/slip/{theId}")
    public SlipDTO findById(@PathVariable Integer theId)
    {
        return new SlipDTO(slipService.findById(theId));
    }

    @PostMapping("/saveStock")
    public SlipDTO save(@RequestBody SlipDTO slipDTO)
    {
       return slipService.save(slipDTO);
    }

    @DeleteMapping("/delete/{theId}")
    public void deleteSlip(@PathVariable Integer theId)
    {
        slipService.delete(theId);
    }

    @PutMapping("/slip")
    public void put(@RequestBody SlipDTO slipDTO)
    {

    }

}
