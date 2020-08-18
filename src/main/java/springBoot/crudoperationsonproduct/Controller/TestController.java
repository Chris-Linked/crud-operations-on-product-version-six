package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.crudoperationsonproduct.Repository.SlipInfoRepositoryCustom;
import springBoot.crudoperationsonproduct.Projection.Test;

import java.util.List;

@RestController
@RequestMapping("/testing")
public class TestController {

    @Autowired
    private SlipInfoRepositoryCustom slipInfoRepositoryCustom;

    @GetMapping("/findAll/{barcode}/{warehouse}/{shelf}")
    public List<Test> findAll(@PathVariable String barcode, @PathVariable String warehouse,
                              @PathVariable String shelf)
    {
        return slipInfoRepositoryCustom.findWarAndMore(barcode, warehouse, shelf);
    }
}
