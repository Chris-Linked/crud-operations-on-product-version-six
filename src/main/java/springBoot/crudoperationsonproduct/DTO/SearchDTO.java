package springBoot.crudoperationsonproduct.DTO;

public class SearchDTO {

    private String barcode;
    private String wherehouseDesc;
    private String shelf;


    public SearchDTO(String barcode, String wherehouseDesc, String shelf, Integer quantity) {
        this.barcode = barcode;
        this.wherehouseDesc = wherehouseDesc;
        this.shelf = shelf;

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getWherehouseDesc() {
        return wherehouseDesc;
    }

    public void setWherehouseDesc(String wherehouseDesc) {
        this.wherehouseDesc = wherehouseDesc;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

}
