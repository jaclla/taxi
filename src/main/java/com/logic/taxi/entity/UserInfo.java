package com.logic.taxi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author logic
 * @Description:
 * @time 2018/4/18 11:55
 */
@Data
public class UserInfo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;


}
