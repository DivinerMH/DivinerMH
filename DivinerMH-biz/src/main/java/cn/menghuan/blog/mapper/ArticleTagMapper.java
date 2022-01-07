package cn.menghuan.blog.mapper;

import cn.menghuan.blog.entity.SysArticleTag;
import cn.menghuan.blog.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<SysArticleTag> {

    List<SysTag> findByArticleId(long articleId);

}
