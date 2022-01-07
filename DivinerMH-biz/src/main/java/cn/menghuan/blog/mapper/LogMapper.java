package cn.menghuan.blog.mapper;


import cn.menghuan.blog.entity.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author tycoding
 * @date 2020/6/27
 */
@Mapper
public interface LogMapper extends BaseMapper<SysLog> {

}
