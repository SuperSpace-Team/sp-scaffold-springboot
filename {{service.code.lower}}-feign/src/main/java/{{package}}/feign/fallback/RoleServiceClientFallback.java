package {{package}}.feign.fallback;

import com.sp.framework.common.enums.SystemErrorCodeEnum;
import com.sp.framework.common.utils.ResponseUtil;
import com.sp.framework.common.vo.BasePageQueryRespVO;
import com.sp.framework.common.vo.ResponseVO;
import {{package}}.api.enums.BusinessErrorCodeEnum;
import {{package}}.feign.vo.QueryRolesPageReqVO;
import {{package}}.feign.vo.RoleInfoVO;
import org.springframework.web.bind.annotation.RequestBody;
import {{package}}.feign.client.role.RoleServiceClient;

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
