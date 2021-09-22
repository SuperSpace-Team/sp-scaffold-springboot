package com.yh.scaffold.springboot.api.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: luchao
 * @date: Created in 6/22/21 5:21 PM
 */
public class TestDemoConstant {
    /**
     * 规范格式:[模块]_[功能项]_[功能Key]_[功能Value]
     */
    public final static String MODULE_USAGE_FUNCTION_KEY_NAME_VALUE1 = "FuncValue1";
    public final static Integer MODULE_USAGE_FUNCTION_KEY_NAME_VALUE2 = 123;
    public final static Boolean MODULE_USAGE_FUNCTION_KEY_NAME_VALUE3 = true;

    /**
     * APP类型集合定义
     */
    public final static Integer APP_TYPE_DEF_PC = 1;
    public final static Integer APP_TYPE_DEF_WEB = 2;
    public final static Integer APP_TYPE_DEF_ANDROID = 3;
    public final static Integer APP_TYPE_DEF_IOS = 4;
    public final static Map<Integer, String> APP_TYPE_MAP = new HashMap<>();
    static {
        APP_TYPE_MAP.put(APP_TYPE_DEF_PC, "pc");
        APP_TYPE_MAP.put(APP_TYPE_DEF_WEB, "web");
        APP_TYPE_MAP.put(APP_TYPE_DEF_ANDROID, "android");
        APP_TYPE_MAP.put(APP_TYPE_DEF_IOS, "iOS");
    }
}
