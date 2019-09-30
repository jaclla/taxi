package com.logic.taxi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.TaxiInfo;

public interface TaxiInfoService extends IService<TaxiInfo> {


  RetResult insert(TaxiInfo record);

  RetResult selectPage(Boolean type, Page<TaxiInfo> objectPage);

  RetResult selectList(Boolean type);
}
