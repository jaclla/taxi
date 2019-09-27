package com.logic.taxi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.SysDictionaryItem;
import com.logic.taxi.mapper.SysDictionaryItemMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.logic.taxi.mapper.SysDictionaryTypeMapper;
import com.logic.taxi.entity.SysDictionaryType;
import com.logic.taxi.service.SysDictionaryTypeService;
@Service
public class SysDictionaryTypeServiceImpl extends ServiceImpl<SysDictionaryTypeMapper, SysDictionaryType> implements SysDictionaryTypeService{

    @Resource
    private SysDictionaryTypeMapper sysDictionaryTypeMapper;
    @Resource
    private SysDictionaryItemMapper sysDictionaryItemMapper;

    @Override
    public RetResult getListDictionary() {
        List<SysDictionaryType> sysDictionaryTypeList = sysDictionaryTypeMapper.selectList(new QueryWrapper<>());
        Map<String, List> map = new HashMap<>();
        for (SysDictionaryType sdt :
            sysDictionaryTypeList) {
            List<Map<String, Object>> itemMap = sysDictionaryItemMapper.selectMaps(new QueryWrapper<SysDictionaryItem>().select("itemName,itemValue").eq("typeID", sdt.getId()).orderByAsc("orderNumber is null", "orderNumber"));
            map.put(sdt.getCode(), itemMap);
        }
        return RetResponse.makeOKRsp(map);
    }
}
