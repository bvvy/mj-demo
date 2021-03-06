package com.divide2.product.service.impl;

import com.divide2.core.root.converter.Converter;
import com.divide2.product.bo.UnitBO;
import com.divide2.product.dto.UnitDTO;
import com.divide2.product.model.Product;
import com.divide2.product.model.ProductSpec;
import com.divide2.product.model.Unit;
import com.divide2.product.repo.ProductRepository;
import com.divide2.product.repo.ProductSpecRepository;
import com.divide2.product.repo.StockRepository;
import com.divide2.product.repo.UnitRepository;
import com.divide2.product.service.ProductConnectService;
import com.divide2.product.vo.ProductVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvvy
 * @date 2018/12/28
 */
@Service
public class ProductConnectServiceImpl implements ProductConnectService {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final ProductSpecRepository productSpecRepository;
    private final UnitRepository unitRepository;


    public ProductConnectServiceImpl(ProductRepository productRepository,
                                     StockRepository stockRepository,
                                     ProductSpecRepository productSpecRepository, UnitRepository unitRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.productSpecRepository = productSpecRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public ProductVO getProductVO(String productId) {
        Product product = productRepository.getOne(productId);
        return this.mergeProductSpecs(product);
    }

    private ProductVO mergeProductSpecs(Product product) {
        ProductVO vo = ProductVO.of(product);
        List<ProductSpec> productSpecs = productSpecRepository.findByProductId(product.getId());
        vo.setSpecs(productSpecs);
        return vo;
    }


    @Override
    public Product getProduct(String productId) {
        return productRepository.getOne(productId);
    }

    @Override
    public ProductSpec getProductSpec(String productSpecId) {
        return productSpecRepository.getOne(productSpecId);
    }

    @Override
    public void saveOrUpdateUnit(String teamId, UnitBO bo) {
        Unit unit = new Unit();
        unit.setId(bo.getId());
        unit.setRate(bo.getRate());
        unit.setName(bo.getName());
        unit.setChild(bo.getChild());
        unit.setTeamId(teamId);
        unitRepository.save(unit);
    }

    @Override
    @Transactional
    public void saveOrUpdateUnits(String teamId, List<UnitBO> bos) {
        bos.forEach(bo -> this.saveOrUpdateUnit(teamId, bo));
    }

    @Override
    public List<UnitDTO> getUnits(String[] unitIds) {
        List<Unit> units = unitRepository.findByIdIn(Arrays.asList(unitIds));
        return Converter.of(units).convert(this::toUnit);
    }

    private  UnitDTO toUnit(Unit unit) {
        return new UnitDTO(unit.getId(), unit.getName(), unit.getRate());
    }
}
