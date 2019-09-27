package com.logic.taxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logic.taxi.entity.TaxiInfo;

public interface TaxiInfoMapper extends BaseMapper<TaxiInfo> {
    int insert(TaxiInfo record);

    int insertSelective(TaxiInfo record);
}
