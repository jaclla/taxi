package com.logic.taxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logic.taxi.controller.BaseController;
import com.logic.taxi.entity.SysDictionaryItem;

public interface SysDictionaryItemMapper extends BaseMapper<SysDictionaryItem> {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictionaryItem record);

    int insertSelective(SysDictionaryItem record);

    SysDictionaryItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionaryItem record);

    int updateByPrimaryKey(SysDictionaryItem record);
}
