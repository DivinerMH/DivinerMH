package cn.menghuan.blog.controller;

import cn.menghuan.blog.dto.TbReviewTodayDTO;
import cn.menghuan.blog.service.ITbReviewTodayService;
import cn.menghuan.blog.vo.TbReviewTodayVO;
import cn.menghuan.common.annotation.Log;
import cn.menghuan.common.constants.CommonConstant;
import cn.menghuan.common.constants.enums.BusinessEnum;
import cn.menghuan.common.exception.GlobalException;
import cn.menghuan.common.utils.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 每天内省(TbReviewToday)表控制层
 *
 * @author menghuan
 * @since 2022-01-07 11:32:49
 */
@AllArgsConstructor
@RestController
@RequestMapping(CommonConstant.BASE_API + "/review")
@Api(value = "TbReviewToday", tags = "每天内省模块")
public class TbReviewTodayController {

    /** 服务对象 */
    private final ITbReviewTodayService itbReviewTodayService;

    /**
     * 新增每天内省
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @Log("新增每天内省")
    @PostMapping
    public R<Boolean> saveTbReviewToday(@RequestBody TbReviewTodayDTO tbReviewTodayDTO) {
        itbReviewTodayService.saveTbReviewToday(tbReviewTodayDTO);
        return new R<>();
    }

    /**
     * 根据id（逻辑）删除每天内省
     * @param id 每天内省id
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @Log("删除每天内省")
    @DeleteMapping
    public R<Boolean> deleteTbReviewToday(@RequestParam("id") Integer id) {
        if (null != id) {
            return new R<>(itbReviewTodayService.deleteTbReviewToday(id));
        }
        throw new GlobalException(BusinessEnum.PARAMETER_NULL.getDescription());
    }

    /**
     * 修改每天内省
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return Boolean.TRUE or Boolean.FALSE
     */
    @Log("修改每天内省")
    @PutMapping
    public R<Boolean> updateTbReviewToday(@RequestBody TbReviewTodayDTO tbReviewTodayDTO) {
        return new R<>(itbReviewTodayService.updateTbReviewToday(tbReviewTodayDTO));
    }

    /**
     * 根据id查询每天内省详情(单服务)
     *
     * @param id 每天内省id
     * @return 每天内省展示对象TbReviewTodayVO
     */
    @ApiOperation(value = "根据id查询每天内省详情(单服务)")
    @GetMapping
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "每天内省id"))
    public R<TbReviewTodayVO> queryTbReviewToday(@RequestParam("id") Integer id) {
        if (null != id) {
            return new R<>(itbReviewTodayService.queryTbReviewToday(id));
        }
        throw new GlobalException(BusinessEnum.PARAMETER_NULL.getDescription());
    }

    /**
     * 根据id查询每天内省详情(多服务)
     *
     * @param id 每天内省id
     * @return 每天内省展示对象TbReviewTodayVO
     */
    @ApiOperation(value = "根据id查询每天内省详情(多服务)")
    @GetMapping("/detail")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "每天内省id"))
    public R<TbReviewTodayVO> queryTbReviewTodayDetail(@RequestParam("id") Integer id) {
        if (null != id) {
            return new R<>(itbReviewTodayService.queryTbReviewTodayDetail(id));
        }
        throw new GlobalException(BusinessEnum.PARAMETER_NULL.getDescription());
    }

    /**
     * 无参查询每天内省列表
     *
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    @GetMapping("/lists")
    public R<List<TbReviewTodayVO>> queryTbReviewTodayList() {
        return new R<>(itbReviewTodayService.queryTbReviewTodayList());
    }

    /**
     * 条件查询每天内省列表
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    @PostMapping("/lists/conditions")
    public R<List<TbReviewTodayVO>> queryListByConditions(@RequestBody TbReviewTodayDTO tbReviewTodayDTO) {
        // 数据权限
        // tbReviewTodayDTO.setTenantId(CommonConverter.dataPermission(tbReviewTodayDTO.getTenantId()));
        return new R<>(itbReviewTodayService.queryListByConditions(tbReviewTodayDTO));
    }

    /**
     * 分页条件查询每天内省列表
     *
     * @param tbReviewTodayDTO 每天内省接收入参DTO
     * @return 每天内省展示对象集合TbReviewTodayVOList
     */
    @GetMapping("/page/conditions")
    public R<IPage<TbReviewTodayVO>> queryPageByConditions(Page page, TbReviewTodayDTO tbReviewTodayDTO) {
        // 数据权限
        // tbReviewTodayDTO.setTenantId(CommonConverter.dataPermission(tbReviewTodayDTO.getTenantId()));
        return new R<>(itbReviewTodayService.queryPageByConditions(page, tbReviewTodayDTO));
    }

}
