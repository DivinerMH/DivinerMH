package cn.menghuan.blog.dto;


import cn.menghuan.blog.entity.TbReviewToday;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 每天内省(TbReviewToday)表传输对象
 *
 * @author menghuan
 * @since 2022-01-07 11:32:47
 */
@Data
@ApiModel(value = "每天内省传输对象")
@EqualsAndHashCode(callSuper = true)
public class TbReviewTodayDTO extends TbReviewToday implements Serializable {

    private static final long serialVersionUID = 1L;

}
