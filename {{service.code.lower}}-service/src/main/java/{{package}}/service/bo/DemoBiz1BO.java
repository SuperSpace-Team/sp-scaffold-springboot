package {{package}}.service.bo;

import com.yh.infra.common.bo.BaseBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: [示例]业务1对象
 * @author: ${USER}
 * @date: Created in 8/4/21 10:17 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoBiz1BO extends BaseBO {
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

    /**
     * [示例]用户信息BO
     */
    private UserInfo userInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
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
