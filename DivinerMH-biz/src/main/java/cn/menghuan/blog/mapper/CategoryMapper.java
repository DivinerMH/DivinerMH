package cn.menghuan.blog.mapper;

import cn.menghuan.blog.entity.SysCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface CategoryMapper extends BaseMapper<SysCategory> {

    List<SysCategory> findCategoryByArticleId(long id);

}
