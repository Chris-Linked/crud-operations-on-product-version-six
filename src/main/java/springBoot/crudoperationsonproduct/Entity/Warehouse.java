package springBoot.crudoperationsonproduct.Entity;

import springBoot.crudoperationsonproduct.DTO.WarehouseDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "warehouse",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Shelves> shelves;


    public void addShelve(Shelves shelve)
    {
        this.shelves = new ArrayList<>();
        shelves.add(shelve);
        shelve.setWarehouse(this);
    }
    public Warehouse()
    {

    }
    public Warehouse(WarehouseDto warehouseDto)
    {
        this.id = warehouseDto.getId();
        this.description = warehouseDto.getDescription();

    }
    public Warehouse(String description) {
        this.description = description;

    }

    public List<Shelves> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelves> shelves) {
        this.shelves = shelves;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @OneToOne(mappedBy = "warehouse")
//    private Shelves shelves;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "description")
//    private String description;
//
//    public Warehouse()
//    {
//
//    }
//    public Warehouse(WarehouseDto warehouseDto)
//    {
//        this.id = warehouseDto.getId();
//        this.description = warehouseDto.getDescription();
//    }
//    public Warehouse(String description) {
//        this.description = description;
//    }
//
//    public Shelves getShelves() {
//        return shelves;
//    }
//
//    public void setShelves(Shelves shelves) {
//        this.shelves = shelves;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
