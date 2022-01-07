package cn.menghuan.common.constants;

/**
 * 项目公共常量定义
 *
 * @author tycoding
 * @date 2020/6/27
 */
public interface CommonConstant {

    /** 成功标记 */
    int SUCCESS = 200;

    /** 错误标记 */
    int ERROR = 500;

    /** User-Agent */
    String USER_AGENT = "User-Agent";

    /** Auth Header Key */
    String AUTHORIZATION = "Authorization";

    /** Base API */
    String BASE_API = "/api";

    /** 正常状态：0 */
    String STATUS_NORMAL = "0";

    /** 删除（异常）状态：1 */
    String STATUS_DEL = "1";

    /** 锁定状态：9 */
    String STATUS_LOCK = "9";

}
