package springBoot.crudoperationsonproduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.crudoperationsonproduct.Entity.Stock;
import springBoot.crudoperationsonproduct.Service.StockService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;


    @GetMapping("/quantity/{date}/{barcode}")
    public Stock getQuantity(@PathVariable String date, @PathVariable String barcode ) throws ParseException {

        /*
        String dateInString = "2018-01-19 03:14:07";
        Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateInString);
         */
        Date now = new SimpleDateFormat("yyyy-mm-dd").parse(date);
        return null;

//        List<StockDTO> stockDTOS = new ArrayList<>();
//
//        for(Stock stock2 : stocks)
//        {
//            stockDTOS.add(new StockDTO(stock2));
//        }
//        return stockDTOS;
    }

    @GetMapping("/find/{barcode}")
    public List<Stock> findByBar(@PathVariable String barcode)
    {
        return stockService.findByBar(barcode);
    }

    @GetMapping("/find1/{date}")
    public List<Stock> findByDate(@PathVariable String date) throws ParseException {
//        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-mm-dd");
//        simpleDateFormat.applyLocalizedPattern("yyyy-mm-dd");
//        Date date = simpleDateFormat.parse(date2);

        return stockService.findByDate(date);
    }

    @GetMapping("/stocks")
    public List<Stock> findAll()
    {
        return stockService.findAll();
    }

    @GetMapping("/findby/{barcode}/{date2}")
    public List<Stock> findByBarcodeAndByDate(@PathVariable String barcode, @PathVariable String date2) throws ParseException {

        return stockService.findByBarcodeAndDate(barcode, date2);
    }

    @GetMapping("/findAll/{date}/{barcode}")
    public List<Stock> findByDateAndBarcode(@PathVariable String date, @PathVariable String barcode) throws ParseException {
        return stockService.findAllByDateAndBarcode(date, barcode);
    }
}
