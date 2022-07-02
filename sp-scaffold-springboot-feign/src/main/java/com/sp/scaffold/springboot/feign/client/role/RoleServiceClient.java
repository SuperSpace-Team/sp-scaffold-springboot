package com.sp.scaffold.springboot.feign.client.role;

import com.sp.framework.common.vo.BasePageQueryRespVO;
import com.sp.framework.common.vo.BasePageQueryRespVO;
import com.sp.framework.common.vo.ResponseVO;
import com.sp.scaffold.springboot.feign.fallback.RoleServiceClientFallback;
import com.sp.scaffold.springboot.feign.vo.QueryRolesPageReqVO;
import com.sp.scaffold.springboot.feign.vo.RoleInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: [示例]Feign调用接口定义(name、value和url定义到配置文件中)
 * @author: {{USER}}
 * @date: Created in 10/27/21 7:58 PM
 */
@FeignClient(name = "${sp.role-service.name:}", url="${sp.role-service.url:}", fallback = RoleServiceClientFallback.class)
public interface RoleServiceClient {
    /**
     * [示例]检查角色是否生效
     * @return
     */
    @GetMapping("/test/checkRoleIsValid")
    ResponseVO<Boolean> testCheckRoleIsValid(@RequestParam String roleId);

    /**
     * [示例]获取角色列表
     * @param reqVO 分页请求角色信息(角色名称可模糊查询)
     * @return
     */
    @PostMapping("/test/getRoleList")
    ResponseVO<BasePageQueryRespVO<RoleInfoVO>> testGetRoleList(@RequestBody QueryRolesPageReqVO reqVO);
}
