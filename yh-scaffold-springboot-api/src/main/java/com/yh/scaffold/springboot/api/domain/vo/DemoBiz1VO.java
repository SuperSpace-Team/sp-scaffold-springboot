package com.yh.scaffold.springboot.api.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: [示例]Demo业务1 VO定义
 * @author: ${USER}
 * @date: Created in 8/4/21 10:17 PM
 */
@Data
public class DemoBiz1VO {
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
     * 用户信息VO对象
     */
    private UserInfo userInfo;

    /**
     * [示例]用户信息
     */
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
