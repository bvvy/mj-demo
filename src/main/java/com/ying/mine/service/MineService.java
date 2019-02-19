package com.ying.mine.service;

import com.ying.auth.vo.GroupVO;
import com.ying.auth.vo.UserGroupVO;
import com.ying.friend.dto.MessageDTO;
import com.ying.friend.query.MessageQuery;
import com.ying.friend.vo.ChatVO;
import com.ying.friend.vo.FriendVO;
import com.ying.friend.vo.MessageVO;
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
 * @date 2018/12/10
 */
public interface MineService {

    /**
     * 获取好友
     * @return x
     */
    List<FriendVO> listFriends();

    FriendVO getFriend(Integer friendId);


    /**
     * 获取历史聊天的人
     * @return chat
     */
    List<ChatVO> listChat();

    /**
     * 获取消息
     *
     * @param toUserId 和谁的
     * @param query query
     * @param pageable page
     * @return page message
     */
    Page<MessageVO> findMessage(Integer toUserId, MessageQuery query, Pageable pageable);

    /**
     * 发送消息
     * @param messageDTO dto
     */
    void sendMessage(MessageDTO messageDTO);

    List<GroupVO> listUserGroup();

    List<String> listAuthorities(String groupId);

}
