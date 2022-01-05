package cn.menghuan.blog.controller;

import cn.menghuan.blog.entity.SysLog;
import cn.menghuan.blog.service.LogService;
import cn.menghuan.common.constants.CommonConstant;
import cn.menghuan.common.controller.BaseController;
import cn.menghuan.common.exception.GlobalException;
import cn.menghuan.common.utils.QueryPage;
import cn.menghuan.common.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author tycoding
 * @date 2019-03-13
 */
@RestController
@RequestMapping(CommonConstant.BASE_API + "/log")
@Api(value = "LogController", tags = {"日志管理接口"})
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLog log, QueryPage queryPage) {
        return new R<>(super.getData(logService.list(log, queryPage)));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            logService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
