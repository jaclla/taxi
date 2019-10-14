package com.logic.taxi.service.impl;

import static com.logic.taxi.utils.DateUtils.outTime;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logic.taxi.bean.TaxiInfoBean;
import com.logic.taxi.core.ret.RetResponse;
import com.logic.taxi.core.ret.RetResult;
import com.logic.taxi.entity.SysDictionaryItem;
import com.logic.taxi.entity.TaxiInfo;
import com.logic.taxi.entity.UserInfo;
import com.logic.taxi.mapper.SysDictionaryItemMapper;
import com.logic.taxi.mapper.TaxiInfoMapper;
import com.logic.taxi.mapper.UserInfoMapper;
import com.logic.taxi.service.TaxiInfoService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TaxiInfoServiceImpl extends ServiceImpl<TaxiInfoMapper, TaxiInfo> implements
    TaxiInfoService {

  @Resource
  private TaxiInfoMapper taxiInfoMapper;
  @Resource
  private SysDictionaryItemMapper sysDictionaryItemMapper;
  @Resource
  private UserInfoMapper userInfoMapper;

  @Override
  public RetResult insert(TaxiInfo record, String token) {
    if (StrUtil.isEmpty(token)) {
      return RetResponse.makeErrRsp("请先登录!");
    }
    UserInfo hash = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("hash", token));
    if (hash == null) {
      return RetResponse.makeErrRsp("用户不存在或者已过期请重新登录!");
    }
    return RetResponse.makeOKRsp(taxiInfoMapper.insert(record));
  }

  @Override
  public RetResult selectPage(Boolean type, Page<TaxiInfo> objectPage) {
    return RetResponse.makeOKRsp(
        taxiInfoMapper.selectPage(objectPage, new QueryWrapper<TaxiInfo>().eq("type", type))
    );
  }

  @Override
  public RetResult selectList(Boolean type, Integer serviceType, Integer region) {
    List<TaxiInfoBean> list = taxiInfoMapper.findList(type, serviceType, region);
    for (TaxiInfoBean taxiInfoBean : list) {
      taxiInfoBean.setOutTime(
          outTime(LocalDateTime.now(ZoneId.of("Asia/Shanghai")), taxiInfoBean.getCreateTime()));
      taxiInfoBean.setServiceType(sysDictionaryItemMapper.selectOne(
          new QueryWrapper<SysDictionaryItem>().eq("itemValue", taxiInfoBean.getServiceType())
              .eq("typeID", 1)).getItemname());
      taxiInfoBean.setRegion(sysDictionaryItemMapper.selectOne(
          new QueryWrapper<SysDictionaryItem>().eq("itemValue", taxiInfoBean.getRegion())
              .eq("typeID", 2)).getItemname());
      if (!taxiInfoBean.getSecrecyLabel()) {
        Map<String, String> map = new HashMap<>();
        TaxiInfo taxiInfo = taxiInfoMapper.selectById(taxiInfoBean.getId());
        map.put("tg", taxiInfo.getUsername());
        map.put("email", taxiInfo.getEmail());
        map.put("weChat", taxiInfo.getWechat());
        taxiInfoBean.setInfo(map);
      }
    }
    return RetResponse.makeOKRsp(list);
  }
}
