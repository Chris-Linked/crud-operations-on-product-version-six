package springBoot.crudoperationsonproduct.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import springBoot.crudoperationsonproduct.Entity.*;
import springBoot.crudoperationsonproduct.Projection.QTest;
import springBoot.crudoperationsonproduct.Projection.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SlipInfoRepositoryCustomImpl implements SlipInfoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findProductByBarcode(String barcode) {
        JPAQuery<Product> query = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        QWarehouse warehouse = QWarehouse.warehouse;
        // return query.from(person).where(person.firstname.eq(firstname)).fetch();
        return query.from(product).where(product.barcode.eq(barcode)).fetch();
    }

    @Override
    public List<Test> findProduct(String barcode, String warehouse, String shelf) {
        JPAQuery<Product> query = new JPAQuery<>(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        OrderSpecifier<?> orderSpecifier ;

        QProduct product = QProduct.product;
        QWarehouse warehouse1 = QWarehouse.warehouse;
        QShelves shelves = QShelves.shelves;


        query.from(product)
                .leftJoin(warehouse1)
                .on(warehouse1.description.eq(warehouse))
                .leftJoin(shelves)
                .on(shelves.description.eq(shelf));


        Test test = new Test();
        FactoryExpression<Test> zVPFe = new QTest(
                product.barcode,
                warehouse1.description,
                shelves.description
        );

        if(barcode != null)
        {
            //booleanBuilder.and(zone.name.contains(zoneViewSearchDTO.getName()));
            booleanBuilder.and((product.barcode.contains(barcode)));
        }
        if(warehouse != null)
        {
            booleanBuilder.and((warehouse1.description.contains(warehouse)));
        }
        if(shelf != null)
        {
            booleanBuilder.and(shelves.description.contains(shelf));
        }

        return query.select(zVPFe).where(booleanBuilder).fetch();
    }

    @Override
    public Warehouse findWarehouseByDescription(String description1) {

         JPAQuery<Warehouse> query = new JPAQuery<>(em);
        JPAQueryFactory factory = new JPAQueryFactory(em);
        QWarehouse warehouse = QWarehouse.warehouse;

        Warehouse bob = factory.selectFrom(warehouse)
                .where(warehouse.description.eq(description1))
                .fetchFirst();

        return bob;
    }

    @Override
    public Product findByBarcode(String barcode) {
        JPAQueryFactory factory = new JPAQueryFactory(em);
        QProduct product = QProduct.product;

        Product product1 = factory.selectFrom(product)
                            .where(product.barcode.eq(barcode))
                            .fetchOne();
        return product1;
    }

    @Override
    public List<Test> findWarAndMore(String barcode, String warehouse, String shelf) {
//        JPAQueryFactory factory = new JPAQueryFactory(em);
        List<Test> testList = new ArrayList<>();
        JPAQuery<SlipInfo> query = new JPAQuery<>(em);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QProduct product = QProduct.product;
        QWarehouse warehouse1 = QWarehouse.warehouse;
        QShelves shelves = QShelves.shelves;

//        Product product1 = factory.selectFrom(product)
//                .where(product.barcode.eq(barcode))
//                .fetchOne();
//
//        Warehouse bob = factory.selectFrom(warehouse1)
//                .where(warehouse1.description.eq(warehouse))
//                .fetchFirst();
//
//        Shelves nick = factory.selectFrom(shelves)
//                        .where(shelves.description.eq(shelf)).fetchOne();



        Test test = new Test();
        FactoryExpression<Test> zVPFe = new QTest(
                product.barcode,
                warehouse1.description,
                shelves.description
        );

        if(barcode != null)
        {
            //booleanBuilder.and(zone.name.contains(zoneViewSearchDTO.getName()));
            booleanBuilder.and((product.barcode.contains(barcode)));
        }
        if(warehouse != null)
        {
            booleanBuilder.and((warehouse1.description.contains(warehouse)));
        }
        if(shelf != null)
        {
            booleanBuilder.and(shelves.description.contains(shelf));
        }
        testList = query.select(zVPFe).where(booleanBuilder).fetch();

        return  testList;
    }
}
