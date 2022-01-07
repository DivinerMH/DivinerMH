package cn.menghuan.blog.mapper;

import cn.menghuan.blog.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface TagMapper extends BaseMapper<SysTag> {

    List<SysTag> findByArticleId(long id);

}
