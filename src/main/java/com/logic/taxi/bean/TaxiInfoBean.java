package com.logic.taxi.bean;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;

@Data
public class TaxiInfoBean {

  private String id;

  /**
   * 服务类型 applemusic
   */
  private String serviceType;

  /**
   * 区域
   */
  private String region;

  /**
   * 价格  必须是整数
   */
  private Integer price;

  /**
   * 订阅时间 1月 2月
   */
  private Integer subscriptionDate;

  /**
   * 描述
   */
  private String description;

  /**
   * 时间差
   */
  private String outTime;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  /**
   * 隐私标签
   */
  private Boolean secrecyLabel;

  /**
   * 联系方式
   */
  private Map<String, String> info;

}
