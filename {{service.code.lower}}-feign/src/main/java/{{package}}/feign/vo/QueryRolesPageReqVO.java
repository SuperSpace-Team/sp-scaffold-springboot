package {{package}}.feign.vo;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 查询角色信息请求VO
 * @author: ${USER}
 * @date: Created in 12/18/21 3:12 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRolesPageReqVO extends BasePageQueryReqVO {
    /**
     * 角色名称(模糊查询参数)
     */
    private String roleName;
}
