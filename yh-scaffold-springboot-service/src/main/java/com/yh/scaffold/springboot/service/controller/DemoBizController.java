package com.yh.scaffold.springboot.service.controller;

import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.service.svc.DemoBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @description: 测试业务API
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
    @GetMapping("/test/get")
    public ResponseVO<Boolean> getTestGetResult(){
        return ResponseUtil.getFromData(true);
    }

    @PostMapping("/test/postPagingResult")
    public ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO){
        DemoApiPageRespVO demoApiPageRespVO =
                DozerUtil.map(demoBizService.getPageDataList(queryVO), DemoApiPageRespVO.class);
        demoApiPageRespVO.setDataList(new ArrayList());
        demoApiPageRespVO.setTestCount(30);
        return ResponseUtil.getFromData(demoApiPageRespVO);
    }
}
