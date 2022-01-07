package cn.menghuan.blog.mapper;

import cn.menghuan.blog.entity.SysArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface ArticleMapper extends BaseMapper<SysArticle> {

    List<SysArticle> findByCategory(Long id);

    List<SysArticle> findByTag(Long id);

}
