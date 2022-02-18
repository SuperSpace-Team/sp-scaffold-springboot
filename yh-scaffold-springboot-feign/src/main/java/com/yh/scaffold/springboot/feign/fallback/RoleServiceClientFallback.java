package com.yh.scaffold.springboot.feign.fallback;

import com.yh.infra.common.enums.SystemErrorCodeEnum;
import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.vo.BasePageQueryRespVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.enums.BusinessErrorCodeEnum;
import com.yh.scaffold.springboot.feign.vo.QueryRolesPageReqVO;
import com.yh.scaffold.springboot.feign.vo.RoleInfoVO;
import org.springframework.web.bind.annotation.RequestBody;
import com.yh.scaffold.springboot.feign.client.role.RoleServiceClient;

/**
 * @description: [示例]自定义Feign降级处理实现
 * @author: luchao
 * @date: Created in 2/18/22 2:58 PM
 */
public class RoleServiceClientFallback implements RoleServiceClient {
    @Override
    public ResponseVO<Boolean> testCheckRoleIsValid(String roleId) {
        return ResponseUtil.getFailure(BusinessErrorCodeEnum.DUPLICATE_PARAM_A_ERROR.getCode(),
                BusinessErrorCodeEnum.DUPLICATE_PARAM_A_ERROR.getMsg() + "Role ID:" + roleId);
    }

    @Override
    public ResponseVO<BasePageQueryRespVO<RoleInfoVO>> testGetRoleList(@RequestBody QueryRolesPageReqVO reqVO) {
        return ResponseUtil.getFailure(SystemErrorCodeEnum.BUSINESS_ERROR.getCode(),
                SystemErrorCodeEnum.BUSINESS_ERROR.getMsg() + "Role Name:" + reqVO);

//或者使用:  return ResponseUtil.getFailure(SystemErrorCodeEnum.SYSTEM_ERROR.getCode(),
//                SystemErrorCodeEnum.SYSTEM_ERROR.getMsg());

//或者使用:  return ResponseUtil.getFailure(SystemErrorCodeEnum.SYSTEM_UNKNOWN_EXCEPTION.getCode(),
//                SystemErrorCodeEnum.SYSTEM_UNKNOWN_EXCEPTION.getMsg());
    }
}
