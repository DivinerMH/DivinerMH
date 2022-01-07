package cn.menghuan.blog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Data
@ApiModel(value = "七牛云实体类")
@NoArgsConstructor
@AllArgsConstructor
public class QiNiuEntity implements Serializable {

    @ApiModelProperty(value = "对象KEY", name = "key")
    private String key;

    @ApiModelProperty(value = "对象名称", name = "name")
    private String name;

    @ApiModelProperty(value = "对象类型", name = "type")
    private String type;

    @ApiModelProperty(value = "对象大小", name = "size")
    private long size;

    @ApiModelProperty(value = "对象链接", name = "url")
    private String url;

}
