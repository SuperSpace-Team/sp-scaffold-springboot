package com.yh.scaffold.springboot.api.enums;

import com.yh.infra.common.base.BaseBizEnum;
import com.yh.infra.common.exception.BusinessException;

import java.text.MessageFormat;

public enum BusinessExceptionEnum implements BaseBizEnum {
    DUPLICATE_PARAM_A_ERROR(15010, "存在重复的参数A，请重新输入"),
    NOT_FOUND_SOME_CONFIG_DATA(15012, "找不到某个配置数据,请确认!"),
    MODIFY_SOME_DATA_FAILED(15013, "修改某条数据失败,请重试!"),
    SOME_PARAM_CANNOT_BE_EMPTY(15015, "某个参数xxx不能为空");

    BusinessExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.system = false;
    }

    BusinessExceptionEnum(Integer code, String msg, boolean system) {
        this.code = code;
        this.msg = msg;
        this.system = system;
        if (isSystem()) {
            this.msg = "[".concat(code.toString()).concat("] ").concat(msg);
        }
    }

    private Integer code;

    private String msg;

    /**
     * 是否为系统级别异常
     */
    private boolean system;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public boolean isSystem() {
        return system;
    }

    /**
     * 返回异常（也用于业务判断）
     *
     * @return
     */
    public RuntimeException toException() {
        return system
                ? new RuntimeException(msg)
                : new BusinessException(code, msg);
    }


    /**
     * 返回异常（也用于业务判断）,异常载体支持变量
     *
     * @return
     */
    public RuntimeException toException(Object... args) {
        return system
                ? new RuntimeException(msg)
                : new BusinessException(code, MessageFormat.format(msg, args));
    }

    /**
     * 执行异常
     *
     * @return
     */
    public void triggerException() {
        if (system) {
            throw new RuntimeException(msg);
        } else {
            throw new BusinessException(code, msg);
        }
    }

    /**
     * 执行异常,异常载体支持变量
     *
     * @return
     */
    public void triggerException(Object... args) {
        if (system) {
            throw new RuntimeException(String.format(msg, args));
        } else {
            throw new BusinessException(code, String.format(msg, args));
        }
    }
}