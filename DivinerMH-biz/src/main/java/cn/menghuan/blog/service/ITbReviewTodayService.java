package cn.menghuan.blog.service;


import cn.menghuan.blog.dto.TbReviewTodayDTO;
import cn.menghuan.blog.entity.TbReviewToday;
import cn.menghuan.blog.vo.TbReviewTodayVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 每天内省(TbReviewToday)表服务接口
 *
 * @author menghuan
 * @since 2022-01-07 11:32:48
 */
public interface ITbReviewTodayService extends IService<TbReviewToday> {

    /**
     * 新增每天内省
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean saveTbReviewToday(TbReviewTodayDTO tbReviewTodayDTO);

    /**
     * 根据id（逻辑）删除每天内省
     *
     * @param id 每天内省id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean deleteTbReviewToday(Integer id);

    /**
     * 修改每天内省
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    Boolean updateTbReviewToday(TbReviewTodayDTO tbReviewTodayDTO);

    /**
     * 根据id查询每天内省详情(单服务)
     *
     * @param id 每天内省id
     * @return 每天内省展示对象
     */
    TbReviewTodayVO queryTbReviewToday(Integer id);

    /**
     * 根据id查询每天内省详情(多服务)
     *
     * @param id 每天内省id
     * @return 每天内省展示对象
     */
    TbReviewTodayVO queryTbReviewTodayDetail(Integer id);

    /**
     * 无参查询每天内省列表
     *
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    List<TbReviewTodayVO> queryTbReviewTodayList();

    /**
     * 条件查询每天内省列表
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    List<TbReviewTodayVO> queryListByConditions(TbReviewTodayDTO tbReviewTodayDTO);

    /**
     * 分页条件查询每天内省列表
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    IPage<TbReviewTodayVO> queryPageByConditions(Page page, TbReviewTodayDTO tbReviewTodayDTO);

}
