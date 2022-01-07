package cn.menghuan.blog.mapper;

import cn.menghuan.blog.entity.SysComment;
import cn.menghuan.common.utils.SplineChart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface CommentMapper extends BaseMapper<SysComment> {

    @Select("select date_format(create_time, '%Y-%m-%d') time, count(*) num from tb_comment group by date_format(create_time, '%Y-%m-%d')")
    List<SplineChart> chart();

}
