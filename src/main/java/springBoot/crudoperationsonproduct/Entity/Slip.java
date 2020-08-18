package springBoot.crudoperationsonproduct.Entity;

import springBoot.crudoperationsonproduct.DTO.SlipDTO;
import springBoot.crudoperationsonproduct.DTO.SlipInfoDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "slip")
public class Slip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SlipType type;

    @Column(name = "date")
    private Date date;

    @Column(name = "information")
    private String information;

    @Column(name = "person")
    private String person;

    @OneToMany(mappedBy = "slip")
    private List<SlipInfo> slipInfo = new ArrayList<>();


    public Slip() {
    }

    public Slip(SlipDTO dto)
    {
        this.type = dto.getSlipType();
        this.date = dto.getDate();
        this.person = dto.getPerson();
        this.information = dto.getInformation();
        for(SlipInfoDTO slipInfoDTO : dto.getSlipInfoDTO())
        {
            SlipInfo slipInfo1 = new SlipInfo(slipInfoDTO);
            this.slipInfo.add(slipInfo1);

        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SlipType getType() {
        return type;
    }

    public void setType(SlipType type) {
        this.type = type;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<SlipInfo> getSlipInfo() {
        return slipInfo;
    }

    public void setSlipInfo(List<SlipInfo> slipInfo) {
        this.slipInfo = slipInfo;
    }
}
