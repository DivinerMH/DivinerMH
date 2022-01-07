package cn.menghuan.blog.service.impl;

import cn.menghuan.blog.dto.TbReviewTodayDTO;
import cn.menghuan.blog.entity.TbReviewToday;
import cn.menghuan.blog.mapper.TbReviewTodayMapper;
import cn.menghuan.blog.service.ITbReviewTodayService;
import cn.menghuan.blog.vo.TbReviewTodayVO;
import cn.menghuan.common.constants.CommonConstant;
import cn.menghuan.common.exception.GlobalException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 每天内省(TbReviewToday)表服务实现类
 *
 * @author menghuan
 * @since 2022-01-07 11:32:49
 */
@Slf4j
@Service
@AllArgsConstructor
public class TbReviewTodayServiceImpl extends ServiceImpl<TbReviewTodayMapper, TbReviewToday> implements ITbReviewTodayService {

    private final TbReviewTodayMapper tbReviewTodayMapper;

    @Override
    public Boolean saveTbReviewToday(TbReviewTodayDTO tbReviewTodayDTO) {
        // 校验：名称是否重复
        checkNameUnity(tbReviewTodayDTO);
        // 业务逻辑
        TbReviewToday tbReviewToday = new TbReviewToday();
        BeanUtils.copyProperties(tbReviewTodayDTO, tbReviewToday);
        tbReviewToday.setStatus(CommonConstant.STATUS_NORMAL);
        tbReviewToday.setDelFlag(CommonConstant.STATUS_NORMAL);
        tbReviewToday.setCreateTime(LocalDateTime.now());
        tbReviewToday.setUpdateTime(tbReviewToday.getCreateTime());
        baseMapper.insert(tbReviewToday);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteTbReviewToday(Integer id) {
        // 校验：资源是否存在
        checkResource(id);
        // 业务逻辑
        this.removeById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateTbReviewToday(TbReviewTodayDTO tbReviewTodayDTO) {
        // 校验：名称是否重复（修改时,排除自身）
        if (StringUtils.isNotBlank(tbReviewTodayDTO.getName())) {
            checkNameUnity(tbReviewTodayDTO);
        }
        // 业务逻辑
        TbReviewToday tbReviewToday = new TbReviewToday();
        BeanUtils.copyProperties(tbReviewTodayDTO, tbReviewToday);
        tbReviewToday.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(tbReviewToday);
        return Boolean.TRUE;
    }

    @Override
    public TbReviewTodayVO queryTbReviewToday(Integer id) {
        TbReviewToday tbReviewToday = tbReviewTodayMapper.selectById(id);
        if (null == tbReviewToday) {
            throw new GlobalException("对应资源不存在,请核实后输入");
        }
        TbReviewTodayVO tbReviewTodayVO = new TbReviewTodayVO();
        BeanUtils.copyProperties(tbReviewToday, tbReviewTodayVO);
        return tbReviewTodayVO;
    }

    @Override
    public TbReviewTodayVO queryTbReviewTodayDetail(Integer id) {
        TbReviewTodayVO tbReviewTodayVO = tbReviewTodayMapper.queryTbReviewTodayDetail(id);
        if (null == tbReviewTodayVO) {
            throw new GlobalException("对应资源不存在,请核实后输入");
        }
        return tbReviewTodayVO;
    }

    @Override
    public List<TbReviewTodayVO> queryTbReviewTodayList() {
        return tbReviewTodayMapper.queryTbReviewTodayList();
    }

    @Override
    public List<TbReviewTodayVO> queryListByConditions(TbReviewTodayDTO tbReviewTodayDTO) {
        return tbReviewTodayMapper.queryByConditions(tbReviewTodayDTO);
    }

    @Override
    public IPage<TbReviewTodayVO> queryPageByConditions(Page page, TbReviewTodayDTO tbReviewTodayDTO) {
        return tbReviewTodayMapper.queryByConditions(page, tbReviewTodayDTO);
    }


    /* --------------------------------------------异常处理-----------------------------------------*/

    // 校验：资源是否存在
    private void checkResource(Integer id) {
        TbReviewToday tbReviewToday = baseMapper.selectById(id);
        if (null == tbReviewToday) {
            throw new GlobalException("对应资源不存在,请核实后输入");
        }
    }

    /**
     * 校验：新增 / 修改 name 是否重复【多租户版本】
     * 提示：新增时，id请传入为 null，
     * 修改时，id传入相应值，以排除自身数据
     */
    private void checkNameUnity(TbReviewTodayDTO tbReviewTodayDTO) {
        // 使用 .ne() 排除自身重复的情况
        LambdaQueryWrapper<TbReviewToday> queryWrapper =
                Wrappers.<TbReviewToday>lambdaQuery()
                        // .eq(null != TbReviewTodayDTO.getTenantId(), TbReviewToday::getTenantId, TbReviewTodayDTO.getTenantId())
                        .eq(StringUtils.isNotEmpty(tbReviewTodayDTO.getName()), TbReviewToday::getName, tbReviewTodayDTO.getName())
                        .ne(null != tbReviewTodayDTO.getId(), TbReviewToday::getId, tbReviewTodayDTO.getId());
        List<TbReviewToday> tbReviewTodayList = baseMapper.selectList(queryWrapper);
        if (null != tbReviewTodayList && !tbReviewTodayList.isEmpty()) {
            throw new GlobalException("名称已存在，请核实后输入");
        }
    }

}
