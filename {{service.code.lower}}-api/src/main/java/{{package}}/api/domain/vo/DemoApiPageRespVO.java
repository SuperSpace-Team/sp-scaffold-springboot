package {{package}}.api.domain.vo;

import com.yh.infra.common.vo.BasePageQueryRespVO;
import lombok.Data;

import java.util.List;

/**
 * @description: [示例]分页响应VO类定义
 * @author: ${USER}
 * @date: Created in 8/5/21 3:01 PM
 */
@Data
public class DemoApiPageRespVO extends BasePageQueryRespVO {
    /**
     * 测试属性1
     */
    private List<String> dataList;

    /**
     * 测试属性2
     */
    private Integer testCount;

    /**
     * 测试属性1
     */
    private String testProperty1;

    /**
     * 测试属性2
     */
    private Integer testProperty2;

    /**
     * 测试编码
     */
    private String code;

    /**
     * 测试名称
     */
    private String name;

    /**
     * 测试描述
     */
    private String description;
}
