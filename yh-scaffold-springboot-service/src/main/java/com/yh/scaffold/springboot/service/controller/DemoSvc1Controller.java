package com.yh.scaffold.springboot.service.controller;

import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.rest.DemoSvc1Rest;
import com.yh.scaffold.springboot.service.svc.DemoBizService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @description: 测试业务API
 * @author: luchao
 * @date: Created in 8/4/21 9:59 PM
 */
@Controller
@RequestMapping("/demo")
public class DemoSvc1Controller implements DemoSvc1Rest {
    @Autowired
    DemoBizService1 demoBizService1;

    /**
     * Demo API测试
     * @return
     */
    @Override
    @GetMapping("/test/get")
    public ResponseVO<Boolean> getTestGetResult(){
        return ResponseUtil.getFromData(true);
    }

    @Override
    @PostMapping("/test/postPagingResult")
    public ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO){
        DemoApiPageRespVO demoApiPageRespVO =
                DozerUtil.map(demoBizService1.getPageDataList(queryVO), DemoApiPageRespVO.class);
        demoApiPageRespVO.setDataList(new ArrayList());
        demoApiPageRespVO.setTestCount(30);
        return ResponseUtil.getFromData(demoApiPageRespVO);
    }

    @Override
    @PostMapping("/test/save")
    public ResponseVO<Boolean> getTestGetResult(@RequestBody DemoBiz1BO bo){
        return ResponseUtil.getResponse(demoBizService1.save(bo));
    }

    @Override
    @GetMapping("/test/plus/getByCode")
    public ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code") String code){
        return ResponseUtil.getResponse(demoBizService1.plusTestGetByCode(code));
    }
}
