package com.sp.scaffold.springboot.dao.aop;

import com.sp.framework.orm.lark.orm.aop.QueryAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description: ORM查询切面
 * @author: admin
 * @date: Created in 10/27/21 8:01 PM
 */
@Aspect
@Component
public class OrmQueryAspect extends QueryAspect {

}
