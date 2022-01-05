package cn.menghuan.blog.controller;

import cn.menghuan.blog.entity.SysLoginLog;
import cn.menghuan.blog.service.LoginLogService;
import cn.menghuan.common.annotation.Log;
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
 * @date 2020/6/27
 */
@RestController
@RequestMapping(CommonConstant.BASE_API + "/loginlog")
@Api(value = "LoginLogController", tags = {"登录日志管理接口"})
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLoginLog sysLoginLog, QueryPage queryPage) {
        return new R<>(super.getData(loginLogService.list(sysLoginLog, queryPage)));
    }

    @Log("删除登录日志")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            loginLogService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
