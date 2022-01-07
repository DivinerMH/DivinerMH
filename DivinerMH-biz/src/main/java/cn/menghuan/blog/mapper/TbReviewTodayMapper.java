package cn.menghuan.blog.mapper;


import cn.menghuan.blog.dto.TbReviewTodayDTO;
import cn.menghuan.blog.entity.TbReviewToday;
import cn.menghuan.blog.vo.TbReviewTodayVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 每天内省(TbReviewToday)数据库访问层
 *
 * @author menghuan
 * @since 2022-01-07 11:32:47
 */
@Mapper
public interface TbReviewTodayMapper extends BaseMapper<TbReviewToday> {

    /**
     * 根据id查询每天内省详情(多服务)
     *
     * @param id 每天内省id
     * @return 每天内省展示对象TbReviewTodayVO
     */
    TbReviewTodayVO queryTbReviewTodayDetail(@Param("id") Integer id);

    /**
     * 无参查询每天内省List
     *
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    List<TbReviewTodayVO> queryTbReviewTodayList();

    /**
     * 条件查询每天内省List
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    List<TbReviewTodayVO> queryByConditions(@Param("tbReviewTodayDTO") TbReviewTodayDTO tbReviewTodayDTO);

    /**
     * 分页条件查询每天内省Page
     *
     * @param page             分页参数
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    IPage<TbReviewTodayVO> queryByConditions(@Param("page") Page page, @Param("tbReviewTodayDTO") TbReviewTodayDTO tbReviewTodayDTO);

}
