package cn.menghuan.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文章实体类
 *
 * @author tycoding
 * @date 2020/6/27
 */
@Data
@TableName("tb_article")
@ApiModel(value = "文章实体类")
public class SysArticle implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "文章标题", name = "title")
    private String title;

    @ApiModelProperty(value = "文章作者", name = "author")
    private String author;

    @ApiModelProperty(value = "文章描述", name = "des")
    private String des;

    @ApiModelProperty(value = "文章内容", name = "content")
    private String content;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /* ----------------------------------- 非主表字段 -------------------------------- */

    @ApiModelProperty(value = "文章标签List", name = "tags")
    @TableField(exist = false)
    private List<SysTag> tags;

    @ApiModelProperty(value = "文章分类List", name = "category")
    @TableField(exist = false)
    private SysCategory category;

}
