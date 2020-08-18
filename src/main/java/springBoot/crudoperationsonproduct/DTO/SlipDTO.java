package springBoot.crudoperationsonproduct.DTO;

import springBoot.crudoperationsonproduct.Entity.SlipInfo;
import springBoot.crudoperationsonproduct.Entity.SlipType;
import springBoot.crudoperationsonproduct.Entity.Slip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SlipDTO {


    private Date date;
    private String person;
    private SlipType slipType;
    private String information;
    private List<SlipInfoDTO> slipInfoDTO = new ArrayList<>();

    public SlipDTO() {
    }

    public SlipDTO(Slip slip) {
        this.date = slip.getDate();
        this.person = slip.getPerson();
        this.slipType = slip.getType();
        this.information = slip.getInformation();
        for(SlipInfo slipInfo : slip.getSlipInfo())
        {
            SlipInfoDTO slipInfoDTO = new SlipInfoDTO(slipInfo);
            this.slipInfoDTO.add(slipInfoDTO);
        }
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public SlipType getSlipType() {
        return slipType;
    }

    public void setSlipType(SlipType slipType) {
        this.slipType = slipType;
    }

    public List<SlipInfoDTO> getSlipInfoDTO() {
        return slipInfoDTO;
    }

    public void setSlipInfoDTO(List<SlipInfoDTO> slipInfoDTO) {
        this.slipInfoDTO = slipInfoDTO;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
