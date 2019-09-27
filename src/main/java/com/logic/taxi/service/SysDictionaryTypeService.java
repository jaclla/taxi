package com.logic.taxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.SysDictionaryType;
import com.logic.taxi.entity.TaxiInfo;

public interface SysDictionaryTypeService extends IService<SysDictionaryType> {


    RetResult getListDictionary();

}
