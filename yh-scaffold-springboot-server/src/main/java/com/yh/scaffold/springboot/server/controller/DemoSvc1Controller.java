package com.yh.scaffold.springboot.server.controller;

import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.service.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoBiz1VO;
import com.yh.scaffold.springboot.api.rest.DemoSvc1Rest;
import com.yh.scaffold.springboot.service.user.DemoBizService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @description: 测试业务API
 * @author: ${USER}
 * @date: Created in 8/4/21 9:59 PM
 */
@Controller
@RequestMapping("/demo")
public class DemoSvc1Controller implements DemoSvc1Rest {
    @Autowired
    DemoBizService1 demoBizService1;

    /**
     * [示例]Controller层直接处理返回
     * @return
     */
    @Override
    @GetMapping("/test/get")
    public ResponseVO<Boolean> getTestGetResult(){
        return ResponseUtil.getFromData(true);
    }

    /**
     * [示例]获取分页查询结果数据
     * @param queryVO
     * @return
     */
    @Override
    @PostMapping("/test/postPagingResult")
    public ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO){
        DemoApiPageRespVO demoApiPageRespVO =
                DozerUtil.map(demoBizService1.getPageDataList(queryVO), DemoApiPageRespVO.class);
        demoApiPageRespVO.setDataList(new ArrayList());
        demoApiPageRespVO.setTestCount(30);
        return ResponseUtil.getFromData(demoApiPageRespVO);
    }

    /**
     * [示例]保存数据
     * @param reqVO
     * @return
     */
    @Override
    public ResponseVO<Boolean> getTestGetResult(@RequestBody DemoBiz1VO reqVO){
        //[示例]通过DozerUtil将请求VO对象深拷贝为业务BO对象
        return ResponseUtil.getResponse(demoBizService1.save(DozerUtil.map(reqVO, DemoBiz1BO.class)));
    }

    /**
     * [示例]获取普通查询结果
     * @param code
     * @return
     */
    @Override
    @GetMapping("/test/plus/getByCode")
    public ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code") String code){
        return ResponseUtil.getResponse(demoBizService1.plusTestGetByCode(code));
    }
}
