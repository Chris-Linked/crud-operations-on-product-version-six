package springBoot.crudoperationsonproduct.Projection;

import com.querydsl.core.annotations.QueryProjection;

public class Test {

    private String product;
    private String warehouse;
    private String shelf;

    public Test() {
    }

    @QueryProjection
    public Test(String product, String warehouse, String shelf) {
        this.product = product;
        this.warehouse = warehouse;
        this.shelf = shelf;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
}
