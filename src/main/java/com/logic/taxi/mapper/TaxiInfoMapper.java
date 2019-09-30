package com.logic.taxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logic.taxi.bean.TaxiInfoBean;
import com.logic.taxi.entity.TaxiInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaxiInfoMapper  extends BaseMapper<TaxiInfo> {


  List<TaxiInfoBean> findList(@Param("type") Boolean type, @Param("serviceType") Integer serviceType, @Param("region")Integer region);

}
