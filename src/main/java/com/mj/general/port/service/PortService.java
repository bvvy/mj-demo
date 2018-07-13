package com.mj.general.port.service;

import com.mj.core.service.BasicService;
import com.mj.general.port.dto.PortCheckDTO;
import com.mj.general.port.dto.PortQueryDTO;
import com.mj.general.port.model.Port;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zejun
 * @date 2018/7/9 17:47
 */
public interface PortService extends BasicService<Port,Integer> {

    /**
     * 分页查询
     * @param portQueryDTO 分页查询dto
     * @param pageable 分页数据
     * @return Page<Port>
     */
    Page<Port> find(PortQueryDTO portQueryDTO, Pageable pageable);

    /**
     * 检查字段是否重复
     * @param portCheckDTO  检查字段dto
     */
    void check(PortCheckDTO portCheckDTO);
}