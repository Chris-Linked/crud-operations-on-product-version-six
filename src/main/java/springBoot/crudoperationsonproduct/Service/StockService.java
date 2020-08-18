package springBoot.crudoperationsonproduct.Service;

import springBoot.crudoperationsonproduct.Entity.Stock;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface StockService {

    List<Stock> findByBarcode(String barcode);
    List<Stock> findAll();
   // Stock findByBarcodeAndByDate1(Date date, String barcode);
    public Stock findStock(String barcode, String shelf, Date date);
    List<Stock> findByBar(String barcode);
    List<Stock> findByDate(String date);
    List<Stock> findByBarcodeAndDate(String barcode, String date) throws ParseException;
    List<Stock> findAllByDateAndBarcode(String date, String barcode) throws ParseException;
}
