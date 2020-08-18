package springBoot.crudoperationsonproduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.Stock;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByBarcodeAndShelfAndDate(String barcode, String shelf, Date date);
    Stock findByDateAndBarcode(Date date, String barcode);
    List<Stock> findByBarcode(String barcode);
    List<Stock> findByBarcodeAndDate(String barcode, Date date);
    //List<Stock> findByDate(Date date);
    List<Stock> findAllByDateAndBarcode(Date date, String barcode);

}
