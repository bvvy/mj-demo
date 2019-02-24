package com.ying.team.service;

import com.ying.friend.dto.MenuChatDTO;
import com.ying.team.vo.MenuVO;
import com.ying.team.vo.SquadVO;
import com.ying.auth.vo.UserVO;
import com.ying.core.basic.service.ConnectService;
import com.ying.friend.dto.ChatDTO;
import com.ying.mine.vo.WarehouseVO;
import com.ying.order.query.OrderQueryParam;
import com.ying.order.vo.OrderVO;
import com.ying.product.query.StockQuery;
import com.ying.product.vo.ProductVO;
import com.ying.product.vo.StockVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author bvvy
 * @date 2019/2/17
 */
public interface TeamInnerConnectService extends ConnectService {
    UserVO getUser(Integer userId);

    SquadVO getSquad(String squadId);

    /**
     * 获取团队的仓库
     *
     * @return vo
     */
    List<WarehouseVO> listWarehouse(String teamId);

    /**
     * 库存
     *
     * @param stockQuery q
     * @param pageable   p
     * @return x
     */
    Page<StockVO> findStock(String teamId, StockQuery stockQuery, Pageable pageable);

    /**
     * 获取团队产品
     *
     * @param pageable p
     * @return x
     */
    Page<ProductVO> findProduct(String teamId, Pageable pageable);


    /**
     * 获取收到的订单
     *
     * @param queryParam query
     * @param pageable   pageable
     * @return x
     */
    Page<OrderVO> findReceiveOrder(String teamId, OrderQueryParam queryParam, Pageable pageable);


    /**
     * 获取发送的订单
     *
     * @param queryParam query
     * @param pageable   page
     * @return vo
     */
    Page<OrderVO> findSendOrder(String teamId, OrderQueryParam queryParam, Pageable pageable);


    void addChat(MenuChatDTO chat);

    MenuVO getMenu(String menuCode);

    List<UserVO> listTeamOwnMenuUsers(String teamId, Integer menuId);
}
