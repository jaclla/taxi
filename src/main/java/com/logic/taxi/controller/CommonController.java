package com.logic.taxi.controller;

import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.service.SysDictionaryTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Summer
 * 公共接口 前端控制器
 * @since 2018-09-25
 */
@RestController
@Validated
@RequestMapping("/api/common")
@Api(tags = {"公共控制"}, description = "commonControler")
public class CommonController  {
    @Resource
    private SysDictionaryTypeService sysDictionaryTypeService;

    /**
     * 系统数据字典获取
     *
     * @return
     */
    @Cacheable(value = "dictionary")
    @GetMapping("/dictionary")
    @ApiOperation(value = "获得系统字典", notes = "获得系统字典")
    public RetResult getListDictionary() {
        return sysDictionaryTypeService.getListDictionary();
    }
}
