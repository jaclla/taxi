package com.logic.taxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logic.taxi.bean.TaxiInfoBean;
import com.logic.taxi.entity.TaxiInfo;
import java.util.List;

public interface TaxiInfoMapper  extends BaseMapper<TaxiInfo> {


  List<TaxiInfoBean> findList(Boolean type);

}
