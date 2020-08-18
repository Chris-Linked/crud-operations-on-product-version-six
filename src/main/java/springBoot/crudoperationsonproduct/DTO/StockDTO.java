package springBoot.crudoperationsonproduct.DTO;

import springBoot.crudoperationsonproduct.Entity.Stock;

import java.util.Date;

public class StockDTO {

    private Integer quantity;

    private String barcode;
    private String shelf;
    private Date date;


    public StockDTO() {
    }

    public StockDTO(Stock stock)
    {
        this.quantity = stock.getQuantity();
        this.barcode = stock.getBarcode();
        this.shelf = stock.getShelf();
        this.date = stock.getDate();

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
