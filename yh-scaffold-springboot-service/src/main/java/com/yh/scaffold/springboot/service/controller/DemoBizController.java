package com.yh.scaffold.springboot.service.controller;

import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBizBO;
import com.yh.scaffold.springboot.api.domain.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.service.svc.DemoBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.ArrayList;

/**
 * @description: 测试业务API
 * @author: luchao
 * @date: Created in 8/4/21 9:59 PM
 */
@Controller
@RequestMapping("/demo")
public class DemoBizController {
    @Autowired
    DemoBizService demoBizService;

    /**
     * Demo API测试
     * @return
     */
    @GetMapping("/test/get")
    @ResponseBody
    public ResponseVO<Boolean> getTestGetResult(){
        return ResponseUtil.getFromData(true);
    }

    @PostMapping("/test/postPagingResult")
    @ResponseBody
    public ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO){
        DemoApiPageRespVO demoApiPageRespVO =
                DozerUtil.map(demoBizService.getPageDataList(queryVO), DemoApiPageRespVO.class);
        demoApiPageRespVO.setDataList(new ArrayList());
        demoApiPageRespVO.setTestCount(30);
        return ResponseUtil.getFromData(demoApiPageRespVO);
    }

    @PostMapping("/test/save")
    @ResponseBody
    public ResponseVO<Boolean> getTestGetResult(@RequestBody DemoBizBO bo){
        return ResponseUtil.getResponse(demoBizService.save(bo));
    }

    @GetMapping("/test/plus/getByCode")
    @ResponseBody
    public ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code") String code){
        return ResponseUtil.getResponse(demoBizService.plusTestGetByCode(code));
    }
}
