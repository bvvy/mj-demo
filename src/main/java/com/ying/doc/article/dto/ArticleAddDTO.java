package com.ying.doc.article.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bvvy
 * @date 2018/7/19
 */
@Data
@ApiModel("文章添加")
public class ArticleAddDTO {

    /**
     * 标题
     */
    @NotEmpty
    @ApiModelProperty("标题")
    private String title;
    /**
     * 内容
     */
    @NotEmpty
    @ApiModelProperty("content")
    private String content;
    /**
     * 标签
     */
    @NotEmpty
    @ApiModelProperty("标签")
    private List<String> tags;

    /**
     * 截止日期
     */
    @ApiModelProperty("过期时间")
    private LocalDateTime expiry;

    /**
     * 启用
     */
    @ApiModelProperty("启用")
    private Character enabled;
}