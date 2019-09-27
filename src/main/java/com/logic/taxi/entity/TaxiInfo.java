package com.logic.taxi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class TaxiInfo {

  private Long id;

  /**
   * 信息类型:1 司机 2 乘客
   */
  @TableField("type")
  private Integer type;

  /**
   * 服务类型 applemusic
   */
  @TableField("serviceType")

  private Integer serviceType;

  /**
   * 区域 日区 美区
   */
  @TableField("region")

  private Integer region;

  /**
   * 价格  必须是整数
   */
  @TableField("price")

  private Integer price;

  /**
   * 订阅时间 1月 2月
   */
  @TableField("subscriptionDate")
  private Integer subscriptionDate;

  /**
   * 保密标签 1 保密 0不保密
   */
  @TableField("secrecyLabel")
  private Boolean secrecyLabel;

  /**
   * 描述
   */
  @TableField("description")
  private String description;

  /**
   * 联系邮箱
   */
  @TableField("email")
  private String email;

  /**
   * 微信
   */
  @TableField("wechat")
  private String wechat;
}
