package com.yh.scaffold.springboot.server.controller;

import com.yh.common.lark.common.dao.Pagination;
import com.yh.infra.common.utils.ResponseUtil;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.infra.common.vo.ResponseVO;
import com.yh.scaffold.springboot.service.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoBiz1VO;
import com.yh.scaffold.springboot.api.rest.DemoSvc1Rest;
import com.yh.scaffold.springboot.service.user.DemoBizService1;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: [示例]测试业务API
 * @author: ${USER}
 * @date: Created in 8/4/21 9:59 PM
 */
@RestController
@RequestMapping("/demo")
@Api("[示例]测试业务API接口")
public class DemoSvc1Controller implements DemoSvc1Rest {
    @Autowired
    DemoBizService1 demoBizService1;

    /**
     * [示例]Controller层直接处理返回
     * @return 是否处理成功
     */
    @Override
    @GetMapping("/test/get")
    @ApiOperation("[示例]Controller层直接处理返回")
    public ResponseVO<Boolean> getTestGetResult(){
        return ResponseUtil.getFromData(true);
    }

    /**
     * [示例]获取分页查询结果数据
     * @param queryVO 测试请求分页参数对象
     * @return 分页返回测试数据
     */
    @Override
    @PostMapping("/test/postPagingResult")
    @ApiOperation("[示例]获取分页查询结果数据")
    public ResponseVO getTestPostPagingResult(@RequestBody BasePageQueryReqVO queryVO){
        Pagination<DemoApiPageRespVO> demoApiPagingRespVO =
                DozerUtil.map(demoBizService1.getPageDataList(queryVO), Pagination.class);
        //process sth...
        return ResponseUtil.getFromData(demoApiPagingRespVO);
    }

    /**
     * [示例]保存数据
     * @param reqVO 测试数据对象
     * @return 是否保存数据成功
     */
    @Override
    @PostMapping("/test/saveData")
    @ApiOperation("[示例]保存数据")
    public ResponseVO<Boolean> saveData(@RequestBody DemoBiz1VO reqVO){
        //[示例]通过DozerUtil将请求VO对象深拷贝为业务BO对象
        return ResponseUtil.getResponse(demoBizService1.save(DozerUtil.map(reqVO, DemoBiz1BO.class)));
    }

    /**
     * [示例]获取普通查询结果
     * @param code 测试编码
     * @return 普通查询结果
     */
    @Override
    @GetMapping("/test/plus/getByCode")
    @ApiOperation("[示例]获取普通查询结果")
    public ResponseVO<DemoApiPageRespVO> getPlusTest(@RequestParam("code")
                                                     @ApiParam(name = "code", value = "测试编码", required = true)
                                                                 String code){
        return ResponseUtil.getResponse(demoBizService1.plusTestGetByCode(code));
    }
}
