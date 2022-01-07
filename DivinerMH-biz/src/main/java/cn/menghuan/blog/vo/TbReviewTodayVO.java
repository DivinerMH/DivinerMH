package cn.menghuan.blog.vo;

import cn.menghuan.blog.entity.TbReviewToday;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 每天内省(TbReviewToday)表展示对象
 *
 * @author menghuan
 * @since 2022-01-07 11:28:30
 */
@Data
@ApiModel(value = "每天内省展示对象")
public class TbReviewTodayVO extends TbReviewToday implements Serializable {

    private static final long serialVersionUID = 1L;

}
