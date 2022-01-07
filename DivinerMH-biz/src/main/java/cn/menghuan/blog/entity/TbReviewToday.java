package cn.menghuan.blog.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 每天内省(TbReviewToday)表实体类
 *
 * @author menghuan
 * @since 2022-01-07 11:28:28
 */
@Data
@ApiModel(value = "每天内省实体类")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbReviewToday implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "类型：0-", name = "type")
    private String type;

    @ApiModelProperty(value = "起床时间（点）", name = "wakeUpTime")
    private LocalDateTime wakeUpTime;

    @ApiModelProperty(value = "睡觉时间（点）", name = "sackTime")
    private LocalDateTime sackTime;

    @ApiModelProperty(value = "学习时长（段）（成长）", name = "learningTime")
    private String learningTime;

    @ApiModelProperty(value = "娱乐时长（段）", name = "playingTime")
    private String playingTime;

    @ApiModelProperty(value = "运动时长（段）（健康）", name = "sportTime")
    private String sportTime;

    @ApiModelProperty(value = "吃早餐：0-是 1-否（健康）", name = "isHaveBreakfast")
    private String isHaveBreakfast;

    @ApiModelProperty(value = "听新闻：0-是 1-否（成长）", name = "isListenNews")
    private String isListenNews;

    @ApiModelProperty(value = "描述", name = "description")
    private String description;

    @ApiModelProperty(value = "状态：0-积极 1-奋斗 2-咸鱼 3-划水 4-开心 5-郁闷 6-忧伤 9-消极", name = "status")
    private String status;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除：0-正常 1-删除", name = "delFlag")
    private String delFlag;

}
