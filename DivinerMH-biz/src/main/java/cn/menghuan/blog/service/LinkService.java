package cn.menghuan.blog.service;

import cn.menghuan.blog.entity.SysLink;
import cn.menghuan.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author tycoding
 * @date 2020/6/27
 */
public interface LinkService extends IService<SysLink> {

    List<SysLink> list(SysLink sysLink);

    IPage<SysLink> list(SysLink sysLink, QueryPage queryPage);

    void add(SysLink sysLink);

    void update(SysLink sysLink);

    void delete(Long id);
}
