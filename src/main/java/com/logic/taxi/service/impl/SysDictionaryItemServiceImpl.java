package com.logic.taxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.mapper.TaxiInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.logic.taxi.mapper.SysDictionaryItemMapper;
import com.logic.taxi.entity.SysDictionaryItem;
import com.logic.taxi.service.SysDictionaryItemService;
@Service
public class SysDictionaryItemServiceImpl extends ServiceImpl<SysDictionaryItemMapper, SysDictionaryItem> implements SysDictionaryItemService{

    @Resource
    private SysDictionaryItemMapper sysDictionaryItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysDictionaryItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysDictionaryItem record) {
        return sysDictionaryItemMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDictionaryItem record) {
        return sysDictionaryItemMapper.insertSelective(record);
    }

    @Override
    public SysDictionaryItem selectByPrimaryKey(Integer id) {
        return sysDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysDictionaryItem record) {
        return sysDictionaryItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysDictionaryItem record) {
        return sysDictionaryItemMapper.updateByPrimaryKey(record);
    }

}
