package com.logic.taxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.entity.SysDictionaryItem;
import com.logic.taxi.entity.TaxiInfo;

public interface SysDictionaryItemService extends IService<SysDictionaryItem> {


    int deleteByPrimaryKey(Integer id);

    int insert(SysDictionaryItem record);

    int insertSelective(SysDictionaryItem record);

    SysDictionaryItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionaryItem record);

    int updateByPrimaryKey(SysDictionaryItem record);

}
