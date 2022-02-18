package com.yh.scaffold.springboot.feign;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.rest.DemoSvc1Rest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description: Feign调用接口定义
 * @author: {{USER}}
 * @date: Created in 10/27/21 7:58 PM
 */
@FeignClient(name = "${yh.service1.name:scaffold-application}", url="${yh.service1.url:}")
public interface DemoSvc1Client extends DemoSvc1Rest {
    @Override
    @GetMapping("/test/get")
    ResponseVO<Boolean> getTestGetResult();

    @Override
    @PostMapping("/test/postPagingResult")
    ResponseVO<DemoApiPageRespVO> getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO);
}
