package springBoot.crudoperationsonproduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.crudoperationsonproduct.Entity.Stock;
import springBoot.crudoperationsonproduct.Repository.StockRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockImpl implements StockService {


    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> findByBarcode(String barcode) {
        List<Stock> list = findAll();
        List<Stock> list1 = new ArrayList<>();

        for(Stock stock : list)
        {
            if(stock.getBarcode().equals(barcode))
                list1.add(stock);
        }
        return list1;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }



    @Override
    public Stock findStock(String barcode, String shelf, Date date)
    {
        Stock stock =  stockRepository.findByBarcodeAndShelfAndDate(barcode, shelf, date);

        return stock;
    }

    @Override
    public List<Stock> findByBar(String barcode) {
        return stockRepository.findByBarcode(barcode);
    }


    @Override
    public List<Stock> findByDate(String date) {
        List<Stock> stocks = stockRepository.findAll();

        List<Stock> stocks1 = new ArrayList<>();

        for(Stock stock : stocks)
        {
            Date date1 = stock.getDate();
            String data = date1.toString();
            if(data.equals(data))
            {
                stocks1.add(stock);
            }
        }
        return stocks1;
    }

    @Override
    public List<Stock> findByBarcodeAndDate(String barcode, String date) throws ParseException {

        Date now = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-mm-dd");
        Date date1 = simpleDateFormat.parse(date);

        List<Stock> stocks = stockRepository.findAll();
        List<Stock> stocks1 = new ArrayList<>();
        for(Stock stock : stocks)
        {
            Date date2 = stock.getDate();
            String date3 = date2.toString();
            String now2 = now.toString();
            if(now2.equals(date3))
            {
                stocks1.add(stock);
            }
        }

        return stocks1;
    }

    @Override
    public List<Stock> findAllByDateAndBarcode(String date, String barcode) throws ParseException {

        return stockRepository.findAllByDateAndBarcode
                (new SimpleDateFormat("yyyy-MM-dd").parse(date), barcode);

    }
}
