package {{package}}.api.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: [示例]Demo业务1 VO定义
 * @author: ${USER}
 * @date: Created in 8/4/21 10:17 PM
 */
@Data
@ApiModel(value = "Demo业务对象", description = "[示例]Demo业务1 VO定义")
public class DemoBiz1VO {
    /**
     * 测试数据列表
     */
    @ApiModelProperty(name = "dataList", value = "测试数据列表", required = true)
    @NotEmpty(message = "测试数据列表不能为空!")
    private List<String> dataList;

    /**
     * 测试个数
     */
    @ApiModelProperty(name = "testCount", value = "测试个数", required = true)
    @NotBlank(message = "测试个数不能为空!")
    private Integer testCount;

    /**
     * 测试属性1
     */
    @ApiModelProperty(name = "testProperty1", value = "测试属性1")
    private String testProperty1;

    /**
     * 测试属性2
     */
    @ApiModelProperty(name = "testProperty2", value = "测试属性2", required = true)
    @NotBlank(message = "测试属性2不能为空!")
    private Integer testProperty2;

    /**
     * 测试编码
     */
    @ApiModelProperty(name = "code", value = "测试编码")
    private String code;

    /**
     * 测试名称
     */
    @ApiModelProperty(name = "name", value = "测试名称")
    private String name;

    /**
     * 测试描述
     */
    @ApiModelProperty(name = "description", value = "测试描述")
    private String description;

    /**
     * 用户信息VO对象
     */
    @ApiModelProperty(name = "userInfo", value = "用户信息", required = true)
    @NotNull(message = "用户信息不能为空!")
    private UserInfo userInfo;

    /**
     * [示例]用户信息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel(value = "Demo用户信息", description = "[示例]用户信息定义")
    public static class UserInfo {
        /**
         * 用户ID
         */

        private Integer userId;

        /**
         * 用户编码
         */
        private String userCode;
    }
}
