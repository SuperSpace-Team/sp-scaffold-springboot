package {{package}}.feign.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: [示例]角色信息VO
 * @author: luchao
 * @date: Created in 2/18/22 3:09 PM
 */
@Data
@NoArgsConstructor
public class RoleInfoVO {
    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;
}
