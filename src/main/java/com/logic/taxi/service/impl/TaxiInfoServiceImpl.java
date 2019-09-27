package com.logic.taxi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.mapper.TaxiInfoMapper;
import com.logic.taxi.service.TaxiInfoService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TaxiInfoServiceImpl extends ServiceImpl<TaxiInfoMapper, TaxiInfo> implements
    TaxiInfoService {

  @Resource
  private TaxiInfoMapper taxiInfoMapper;

  @Override
  public RetResult insert(TaxiInfo record) {
    return RetResponse.makeOKRsp(taxiInfoMapper.insert(record));
  }

  @Override
  public RetResult selectPage(Boolean type, Page<TaxiInfo> objectPage) {
    return RetResponse.makeOKRsp(
        taxiInfoMapper.selectPage(objectPage, new QueryWrapper<TaxiInfo>().eq("type", type))
    );
  }
}
