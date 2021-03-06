package com.divide2.team.service.impl;


import com.divide2.auth.service.UserService;
import com.divide2.auth.vo.UserVO;
import com.divide2.core.er.Loginer;
import com.divide2.friend.dto.TeamMenuChatDTO;
import com.divide2.friend.service.ChatService;
import com.divide2.mine.vo.WarehouseVO;
import com.divide2.order.query.OrderQueryParam;
import com.divide2.order.service.OrderService;
import com.divide2.order.vo.OrderVO;
import com.divide2.product.query.StockQuery;
import com.divide2.product.service.ProductService;
import com.divide2.product.service.StockService;
import com.divide2.product.service.WarehouseService;
import com.divide2.product.vo.ProductVO;
import com.divide2.product.vo.StockStreamVO;
import com.divide2.product.vo.StockVO;
import com.divide2.team.model.Acl;
import com.divide2.team.service.AclService;
import com.divide2.team.service.MenuService;
import com.divide2.team.service.SquadService;
import com.divide2.team.service.TeamInnerConnectService;
import com.divide2.team.vo.MenuVO;
import com.divide2.team.vo.SquadVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bvvy
 * @date 2019/2/17
 */
@Service
public class TeamInnerConnectServiceImpl implements TeamInnerConnectService {

    private final UserService userService;
    private final SquadService squadService;
    private final OrderService orderService;
    private final WarehouseService warehouseService;
    private final ProductService productService;
    private final StockService stockService;
    private final ChatService chatService;
    private final MenuService menuService;
    private final AclService aclService;

    public TeamInnerConnectServiceImpl(
            UserService userService,
            SquadService squadService,
            OrderService orderService,
            WarehouseService warehouseService,
            ProductService productService,
            StockService stockService,
            ChatService chatService,
            MenuService menuService,
            AclService aclService) {

        this.userService = userService;
        this.squadService = squadService;
        this.orderService = orderService;
        this.warehouseService = warehouseService;
        this.productService = productService;
        this.stockService = stockService;
        this.chatService = chatService;
        this.menuService = menuService;
        this.aclService = aclService;
    }

    @Override
    public UserVO getUser(Integer userId) {
        return userService.getVO(userId);
    }

    @Override
    public SquadVO getSquad(String squadId) {
        return squadService.getVO(squadId);
    }


    @Override
    public Page<OrderVO> findReceiveOrder(String teamId, OrderQueryParam queryParam, Pageable pageable) {
        return orderService.findTeamReceiveOrder(teamId, queryParam, pageable);
    }


    @Override
    public Page<OrderVO> findSendOrder(String teamId, OrderQueryParam queryParam, Pageable pageable) {
        return orderService.findTeamSendOrder(teamId, queryParam, pageable);
    }

    @Override
    public List<WarehouseVO> listWarehouse(String teamId) {
        return warehouseService.listByTeam(teamId);
    }

    @Override
    public Page<StockVO> findStock(String teamId, StockQuery stockQuery, Pageable pageable) {
        return stockService.findByTeam(teamId, stockQuery, pageable);
    }

    @Override
    public Page<StockStreamVO> findStockStream(String teamId, StockQuery stockQuery, Pageable pageable) {
        return stockService.findStockStream(teamId, stockQuery, pageable);
    }

    @Override
    public Page<ProductVO> findProduct(String teamId, Pageable pageable) {
        return productService.findByTeam(teamId, pageable);
    }

    @Override
    public void addChat(TeamMenuChatDTO chat) {
        chatService.addMenuChat(chat);
    }

    @Override
    public MenuVO getMenu(String menuId) {
        return menuService.getVO(menuId);
    }

    @Override
    public List<UserVO> listTeamOwnMenuUsers(String teamId, Integer menuId) {
        return null;
    }

    @Override
    public Set<String> listTeamUserChildrenMenuIds(String teamId, String type, String principleId) {
        Set<String> authorities = new HashSet<>();
        if (Acl.USER_TYPE.equals(type)) {
            authorities = aclService.listOnlyTeamUserAuthorities(teamId, Integer.parseInt(principleId));

        } else if (Acl.SQUAD_TYPE.equals(type)) {
            authorities = aclService.listOnlyTeamSquadAuthorities(teamId, principleId);
        }
        return menuService.findChildrenMenuIdsByAuthorities(authorities);
    }

    @Override
    public List<SquadVO> listSquadByTeam(String teamId) {
        return squadService.listByTeam(teamId);
    }

    @Override
    public Set<String> listMemberAuthorities(String teamId) {
        return aclService.listTeamUserAuthorities(teamId, Loginer.userId());
    }

}
