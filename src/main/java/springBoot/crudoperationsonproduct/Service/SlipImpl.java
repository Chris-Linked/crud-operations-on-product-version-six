package springBoot.crudoperationsonproduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.crudoperationsonproduct.DTO.SlipDTO;
import springBoot.crudoperationsonproduct.DTO.SlipInfoDTO;
import springBoot.crudoperationsonproduct.Entity.*;
import springBoot.crudoperationsonproduct.Exceptsions.ResourceNotFoundException;
import springBoot.crudoperationsonproduct.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class SlipImpl implements SlipService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShelvesRepository shelvesRepository;

    @Autowired
    SlipInfoRepository slipInfoRepository;

    @Autowired
    ShelvesService shelvesService;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    SlipRepository slipRepository;

    @Autowired
    StockService stockService;

    @Override
    public List<Slip> findAll() {
        return slipRepository.findAll();
    }

    @Override
    public Slip findById(Integer theId) {
        Optional<Slip> result = slipRepository.findById(theId);
        Slip slip = null;
        if (result.isPresent()) {
            return slip = result.get();
        } else {
            throw new ResourceNotFoundException("slip with id " + theId + " was not found");
        }

    }

    @Override
    public SlipDTO save(SlipDTO slipDTO) {
        List<SlipInfoDTO> list = slipDTO.getSlipInfoDTO();
        Slip slip = new Slip(slipDTO);
        SlipInfo slipInfo = new SlipInfo();
        List<Stock> stocks = stockRepository.findAll();
        Stock stock = new Stock();
        // check if type is IMPORT

        if (slip.getType().equals(SlipType.IMPORT)) {
            if (list.isEmpty()) {
                throw new ResourceNotFoundException("list is empty");
            } else {

                for (SlipInfoDTO slipInfoDTO : list) {

                    Shelves shelves = shelvesRepository.findByDescription(slipInfoDTO.getShelfCode());
                    Product product = productRepository.findByBarcode(slipInfoDTO.getProductBarcode());

                    Integer quantity = slipInfoDTO.getQuantity();
                    if (quantity == null || quantity <= 0) {
                        throw new ResourceNotFoundException("quantity cannot be null or 0");
                    }

                    String barcode = slipInfoDTO.getProductBarcode();
                    if (barcode == null) {
                        throw new ResourceNotFoundException("barcode cannot be null");
                    }

                    String selfCode = slipInfoDTO.getShelfCode();
                    if (selfCode == null) {
                        throw new ResourceNotFoundException("selfcode cannot be null");
                    }
                    if (slipDTO.getDate() == null) {
                        throw new ResourceNotFoundException("date cannot be null");
                    }

                    List<Stock> stocks1 = stockRepository.findAll();
                    if(stocks1.contains(stock))
                    {
                        Stock stock2 = new Stock();
                        stock2.setQuantity(quantity);
                        stock2.setDate(slipDTO.getDate());
                        stock2.setBarcode(barcode);
                        stock2.setShelf(selfCode);
                        slipInfo.setQuantity(quantity);
                        slipInfo.setSlip(slip);
                        slipInfo.setProduct(product);
                        slipInfo.setShelves(shelves);
                        slipRepository.save(slip);
                        stockRepository.save(stock2);
                        slipInfoRepository.save(slipInfo);
                        return slipDTO;

                    }else if (stockService.findStock(barcode, selfCode, slipDTO.getDate()) != null) {
                        Stock stock1 = stockService.findStock(barcode, selfCode, slipDTO.getDate());
                        String bar = stock1.getBarcode();
                        Integer quan = stock1.getQuantity();
                        stock1.setQuantity(quantity + quan);
                        stockRepository.save(stock1);
                        return slipDTO;
                    }else {
                        stock.setBarcode(barcode);
                        stock.setShelf(selfCode);
                        stock.setQuantity(quantity);
                        stock.setDate(slip.getDate());
                        slipInfo.setQuantity(quantity);
                        slipInfo.setProduct(product);
                        slipInfo.setShelves(shelves);
                        slipInfo.setSlip(slip);
                    }
                }
            }
            slipRepository.save(slip);
            slipInfoRepository.save(slipInfo);
            stockRepository.save(stock);

            // check if type is export
        } else if (slip.getType().equals(SlipType.EXPORT)) {
            if (list.isEmpty()) {
                throw new ResourceNotFoundException("list is empty");
            } else {
                for (SlipInfoDTO slipInfoDTO : list) {
                    Shelves shelves = shelvesRepository.findByDescription(slipInfoDTO.getShelfCode());
                    Product product = productRepository.findByBarcode(slipInfoDTO.getProductBarcode());

                    Integer quantity = slipInfoDTO.getQuantity();
                    if (quantity == null || quantity <= 0) {
                        throw new ResourceNotFoundException("quantity cannot be null or 0");
                    }

                    String barcode = slipInfoDTO.getProductBarcode();
                    if (barcode == null) {
                        throw new ResourceNotFoundException("barcode cannot be null");
                    } else {
                        // stock.setBarcode(barcode);
                    }

                    String selfCode = slipInfoDTO.getShelfCode();

                    if (selfCode == null) {
                        throw new ResourceNotFoundException("selfcode cannot be null");
                    } else {
                        // stock.setShelf(selfCode);
                    }
                    if (slip.getDate() == null) {
                        throw new ResourceNotFoundException("date cannot be null");
                    } else {
                        // stock.setDate(slip.getDate());
                    }

                    if (stockService.findStock(barcode, selfCode, slipDTO.getDate()) != null) {
                        Stock stock1 = stockService.findStock(barcode, selfCode, slipDTO.getDate());
                        String bar = stock1.getBarcode();
                        Integer quan = stock1.getQuantity();
                        if(quan <= 0)
                        {
                            throw new ResourceNotFoundException("quantity is 0 or less");
                        }
                        stock1.setQuantity(quan - quantity);
                        stock1.setDate(slip.getDate());
                        stock1.setBarcode(bar);
                        stock1.setShelf(selfCode);
                        slipInfo.setQuantity(quantity);
                        slipInfo.setSlip(slip);
                        slipInfo.setProduct(product);
                        slipInfo.setShelves(shelves);
                        slipRepository.save(slip);
                        stockRepository.save(stock1);
                        slipInfoRepository.save(slipInfo);
                        return slipDTO;
                    }
                    stock.setBarcode(barcode);
                    stock.setShelf(selfCode);
                    stock.setQuantity(quantity);
                    stock.setDate(slip.getDate());
                    slipInfo.setQuantity(quantity);
                    slipInfo.setProduct(product);
                    slipInfo.setShelves(shelves);
                    slipInfo.setSlip(slip);
                }
            }
            slipRepository.save(slip);
            slipInfoRepository.save(slipInfo);
            stockRepository.save(stock);
        }

        return slipDTO;
    }

    @Override
    public void delete(Integer theId) {

        Slip slip = findById(theId);
        if(slip != null)
        {
            slipRepository.delete(slip);
        }else
        {
            throw new ResourceNotFoundException("slip was not found!");
        }
    }
}
