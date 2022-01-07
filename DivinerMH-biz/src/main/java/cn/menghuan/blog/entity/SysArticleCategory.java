package cn.menghuan.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Data
@TableName("tb_article_category")
@ApiModel(value = "文章与文章分类中间表实体类")
public class SysArticleCategory implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "文章id", name = "articleId")
    @TableField("article_id")
    private Long articleId;

    @ApiModelProperty(value = "文章分类id", name = "categoryId")
    @TableField("category_id")
    private Long categoryId;

    public SysArticleCategory(Long articleId, Long categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }

}
