package cn.menghuan.common.constants.enums;

/**
 * @Author: menghuan
 * @Date: 2022/1/7 11:50
 */
public enum BusinessEnum {

    /*操作失败*/
    ADD_FAIL(101, "新增失败"),
    UPDATE_FAIL(102, "修改失败"),
    DELETE_FAIL(103, "删除失败"),
    REVIEW_FAIL(104, "审核失败"),

    /*参数为NUll */
    PARAMETER_NULL(110, "参数不能为空"),
    PARAMETER_ID_NULL(111, "参数ID不能为空"),

    /*参数错误*/
    TOKEN_ILLEGAL(121, "Token传参错误!"),
    PARAMETER_ILLEGAL(122, "参数非法"),

    /*数据为空*/
    DATA_NULL(106, "获取数据为空");


    private int code;
    private String description;

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    private BusinessEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
