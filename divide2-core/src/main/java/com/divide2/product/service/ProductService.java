package com.divide2.product.service;

import com.divide2.core.basic.service.BasicService;
import com.divide2.product.dto.ProductDTO;
import com.divide2.product.dto.ProductUpdateDTO;
import com.divide2.product.model.Product;
import com.divide2.product.vo.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author bvvy
 * @date 2018/8/16
 */
public interface ProductService extends BasicService<Product,String> {


    /**
     * 获取公司下的商品
     * @param teamId teamId
     * @return x
     */
    Page<ProductVO> findByTeam(String teamId, Pageable pageable);

    /**
     * 添加
     * @param dto dto
     */
    void add(ProductDTO dto);

    /**
     * 修改
     * @param dto dto
     */
    void update(ProductUpdateDTO dto);


    /**
     * 获取详细信息
     * @param pageable 分页
     * @return vo
     */
    Page<ProductDTO> findInfo(Pageable pageable);

    ProductVO getVO(String productId);

    /**
     * 通过集获取
     *
     * @param ids ids
     */
    List<ProductVO> findByIds(List<String> ids);
}
