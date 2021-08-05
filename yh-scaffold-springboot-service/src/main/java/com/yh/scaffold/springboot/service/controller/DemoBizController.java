package com.yh.scaffold.springboot.service.controller;

import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.service.svc.DemoBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 9:59 PM
 */
@RequestMapping("/demo")
public class DemoBizController {
    @Autowired
    DemoBizService demoBizService;

    /**
     * Demo API测试
     * @return
     */
    @GetMapping
    public ResponseVO<Boolean> getTestResult(){
        return ResponseUtil.getFromData(true);
    }
}
