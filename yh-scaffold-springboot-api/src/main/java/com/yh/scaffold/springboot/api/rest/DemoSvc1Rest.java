package com.yh.scaffold.springboot.api.rest;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 对内/外REST API定义层
 * @author: luchao
 * @date: Created in 10/27/21 8:01 PM
 */
public interface DemoSvc1Rest {

    @GetMapping("/test/get")
    ResponseVO<Boolean> getTestGetResult();

    @PostMapping("/test/postPagingResult")
    ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO);

    @PostMapping("/test/save")
    ResponseVO<Boolean> getTestGetResult(@RequestBody DemoBiz1BO bo);

    @GetMapping("/test/plus/getByCode")
    ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code") String code);
}
