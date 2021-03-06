package com.divide2.team.controller;

import com.divide2.core.data.del.SingleStringId;
import com.divide2.team.model.Attention;
import com.divide2.team.service.AttentionService;
import com.divide2.core.data.resp.Messager;
import com.divide2.core.er.Responser;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author bvvy
 * @date 2019/1/23
 */
@RestController
@RequestMapping("/v1/attention")
public class AttentionController {

    private final AttentionService attentionService;

    public AttentionController(AttentionService attentionService) {
        this.attentionService = attentionService;
    }

    @PostMapping
    @ApiOperation("添加")
    public ResponseEntity<Messager> add(@Valid @RequestBody Attention attention, BindingResult br) {
        attentionService.add(attention);
        return Responser.created();
    }

    @PatchMapping
    @ApiOperation("修改")
    public ResponseEntity<Messager> update(@Valid @RequestBody Attention update, BindingResult br) {
        Attention attention = attentionService.get(update.getId());
        attention.setContent(update.getContent());
        attentionService.update(attention);
        return Responser.updated();
    }

    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Messager> delete(@Valid @RequestBody SingleStringId id, BindingResult br) {
        attentionService.delete(id.getId());
        return Responser.deleted();
    }

    @GetMapping("/all")
    @ApiOperation("全部")
    public ResponseEntity<List<Attention>> get(@PathVariable Integer id) {
        List<Attention> attentions = attentionService.findAll();
        return Responser.ok(attentions);
    }

}
