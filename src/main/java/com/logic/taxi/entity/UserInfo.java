package com.logic.taxi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {

  private static final long serialVersionUID = 1L;

  private Long id;
  @TableField("authDate")
  private Long authDate;
  @TableField("firstName")
  private String firstName;
  @TableField("lastName")
  private String lastName;
  @TableField("hash")
  private String hash;
  @TableField("photoUrl")
  private String photoUrl;
  @TableField("userName")
  private String userName;
  /**
   * 创建时间
   */
  @TableField("createTime")
  private LocalDateTime createTime;

  /**
   * 操作/更新时间
   */
  @TableField("updateTime")
  private LocalDateTime updateTime;


}
