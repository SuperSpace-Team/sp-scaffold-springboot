package {{package}}.api.enums;

import com.yh.infra.common.base.BaseBizEnum;
import com.yh.infra.common.exception.BusinessException;
import com.yh.infra.common.exception.SystemException;

import java.text.MessageFormat;

/**
 * [示例]自定义业务枚举类(需按规范实现BaseBizEnum接口)
 */
public enum BusinessErrorCodeEnum implements BaseBizEnum {
    DUPLICATE_PARAM_A_ERROR(15010, "存在重复的参数A，请重新输入"),
    NOT_FOUND_SOME_CONFIG_DATA(15012, "找不到某个配置数据,请确认!"),
    MODIFY_SOME_DATA_FAILED(15013, "修改某条数据失败,请重试!"),
    SOME_PARAM_CANNOT_BE_EMPTY(15015, "某个参数xxx不能为空");

    BusinessErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.systemException = false;
    }

    BusinessErrorCodeEnum(Integer code, String msg, Boolean systemException) {
        this.code = code;
        this.msg = msg;
        this.systemException = systemException;
        if (isSystemException()) {
            this.msg = String.format("[%]%s", code.toString(), msg);
        }
    }

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 是否为系统级别异常
     */
    private Boolean systemException;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public Boolean isSystemException() {
        return systemException;
    }

    /**
     * 返回异常（也用于业务判断）
     *
     * @return
     */
    public RuntimeException toException() {
        return isSystemException()
                ? new SystemException(msg)
                : new BusinessException(code, msg);
    }


    /**
     * 返回异常（也用于业务判断）,异常载体支持变量
     *
     * @return
     */
    public RuntimeException toException(Object... args) {
        return isSystemException()
                ? new SystemException(msg)
                : new BusinessException(code, MessageFormat.format(msg, args));
    }

    /**
     * 执行/触发异常
     *
     * @return
     */
    public void triggerException() {
        if (isSystemException()) {
            throw new SystemException(msg);
        }

        throw new BusinessException(code, msg);
    }

    /**
     * 执行/触发异常(异常载体支持变量)
     *
     * @return
     */
    public void triggerException(Object... args) {
        if (systemException) {
            throw new RuntimeException(String.format(msg, args));
        }

        throw new BusinessException(code, String.format(msg, args));
    }
}