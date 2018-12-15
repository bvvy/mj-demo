package com.ying.friend.service.impl;

import com.ying.auth.model.User;
import com.ying.auth.vo.UserVO;
import com.ying.core.basic.service.impl.SimpleBasicServiceImpl;
import com.ying.friend.model.Friend;
import com.ying.friend.repo.FriendRepository;
import com.ying.friend.service.FriendConnectService;
import com.ying.friend.service.FriendService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bvvy
 * @date 2018/12/11
 */
@Service
public class FriendServiceImpl extends SimpleBasicServiceImpl<Friend,Integer, FriendRepository>
        implements FriendService {

    private final FriendRepository friendRepository;
    private final FriendConnectService friendConnectService;

    public FriendServiceImpl(FriendRepository friendRepository,
                             FriendConnectService friendConnectService) {
        this.friendRepository = friendRepository;
        this.friendConnectService = friendConnectService;
    }

    @Override
    public List<FriendVO> listByFromId(Integer fromId) {
        List<Friend> friends = friendRepository.findByFromId(fromId);
        return friends.stream().map(friend -> {
            UserVO friendInfo = friendConnectService.getUser(friend.getToId());
            FriendVO vo = new FriendVO();
            vo.setToId(friend.getToId());
            vo.setMemoName(friend.getMemoName());
            vo.setAvatar(friendInfo.getAvatar());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public FriendVO getVO(Integer fromId, Integer toId) {
        return null;
    }
}
