package com.ying.auth.controller;

import com.ying.auth.dto.UserAddDTO;
import com.ying.auth.dto.UserQueryDTO;
import com.ying.auth.dto.UserSearchDTO;
import com.ying.auth.dto.UserUpdateDTO;
import com.ying.auth.model.User;
import com.ying.auth.service.UserService;
import com.ying.auth.vo.UserVO;
import com.ying.core.data.del.SingleId;
import com.ying.core.data.resp.Messager;
import com.ying.core.er.Responser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author bvvy
 */
@RestController
@RequestMapping("/v1/user")
@Api(tags = "用户")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ApiOperation("添加")
    public void add(@Valid @RequestBody UserAddDTO userAddDTO, BindingResult br) {
        User user = User.builder()
                .username(userAddDTO.getUsername())
                .password(userAddDTO.getPassword())
                .nickname(userAddDTO.getNickname())
                .build();
        userService.add(user);
    }

    @PatchMapping
    @ApiOperation("修改")
    public ResponseEntity<Messager> update(@Valid @RequestBody UserUpdateDTO userUpdateDTO, BindingResult br) {
        User user = userService.get(userUpdateDTO.getId());
        userService.update(user);
        return Responser.updated();
    }

    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Messager> delete(@Valid @RequestBody SingleId del, BindingResult br) {
        userService.delete(del.getId());
        return Responser.deleted();
    }


    @GetMapping("/{id}")
    @ApiOperation("获取单个")
    public ResponseEntity<UserVO> get(@PathVariable Integer id) {
        User user = userService.get(id);
        UserVO userVO = UserVO.fromUser(user);
        return Responser.ok(userVO);
    }

    @GetMapping("/search")
    @ApiOperation("查询")
    public ResponseEntity<UserVO> search(UserSearchDTO search) {
        return Responser.ok(userService.search(search));
    }

    @GetMapping("/find")
    @ApiOperation("获取分页")
    public ResponseEntity<Page<UserVO>> find(UserQueryDTO query,Pageable pageable) {
        Page<User> users = userService.find(query, pageable);
        return Responser.ok(users.map(UserVO::fromUser));
    }


}
