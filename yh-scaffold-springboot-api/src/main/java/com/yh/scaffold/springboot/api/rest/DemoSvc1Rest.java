package com.yh.scaffold.springboot.api.rest;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoBiz1VO;
import org.springframework.web.bind.annotation.*;

/**
 * @description: [示例]对内/外REST API接口定义,外部调用方FeignClient接口直接继承即可
 * @author: ${USER}
 * @date: Created in 10/27/21 8:01 PM
 */
public interface DemoSvc1Rest {

    @GetMapping("/test/get")
    ResponseVO<Boolean> getTestGetResult();

    @PostMapping("/test/postPagingResult")
    ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO);

    @PostMapping("/test/save")
    ResponseVO<Boolean> saveData(@RequestBody DemoBiz1VO reqVO);

    @GetMapping("/test/plus/getByCode")
    ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code") String code);
}
