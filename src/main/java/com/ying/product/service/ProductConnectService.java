package com.ying.product.service;

import com.ying.product.bo.UnitBO;
import com.ying.product.dto.UnitDTO;
import com.ying.product.model.Product;
import com.ying.product.model.ProductSpec;
import com.ying.product.vo.ProductVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bvvy
 * @date 2018/12/28
 */
public interface ProductConnectService {
    ProductVO getProductVO(String productId);

    Product getProduct(String productId);

    ProductSpec getProductSpec(String productSpecId);


    void saveOrUpdateUnit(String teamId,UnitBO bo);

    void saveOrUpdateUnits(String teamId, List<UnitBO> bos);

    List<UnitDTO> getUnits(String[] unitIds);
}
