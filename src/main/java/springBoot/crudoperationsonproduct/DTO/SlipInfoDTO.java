package springBoot.crudoperationsonproduct.DTO;

import springBoot.crudoperationsonproduct.Entity.SlipInfo;

public class SlipInfoDTO {

    private String productBarcode;
    private String shelfCode;
    private Integer quantity;


    public SlipInfoDTO() {
    }

    public SlipInfoDTO(SlipInfo slipInfo)
    {
        this.productBarcode = slipInfo.getProduct().getBarcode();
        this.shelfCode = slipInfo.getShelves().getDescription();
        this.quantity = slipInfo.getQuantity();

    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getShelfCode() {
        return shelfCode;
    }

    public void setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
