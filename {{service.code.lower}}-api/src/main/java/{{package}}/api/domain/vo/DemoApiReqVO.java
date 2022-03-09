package {{package}}.domain.vo;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import {{package}}.api.domain.dto.MyBizReqDTO;
import lombok.Data;

/**
 * @description: [示例]API请求VO定义
 * 需以DTO结尾,可继承BaseRequestDTO携带公共属性
 * @author: ${USER}
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class DemoApiReqVO extends BasePageQueryReqVO {
    /**
     * 测试属性1
     */
    private String testProperty1;

    /**
     * 测试属性2
     */
    private Integer testProperty2;

    /**
     * 测试属性3
     */
    private Boolean testProperty3;

    /**
     * 测试属性4
     */
    private MyBizReqDTO testProperty4;
}
