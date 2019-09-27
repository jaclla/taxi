package com.logic.taxi.entity;

import com.logic.taxi.controller.BaseController;
import lombok.Data;

@Data
public class SysDictionaryItem  {
    private Integer id;

    /**
    * 类型ID
    */
    private Integer typeid;

    /**
    * 字典项名称
    */
    private String itemname;

    /**
    * 字典值
    */
    private String itemvalue;

    /**
    * 是否锁定不可修改
    */
    private Byte islock;

    /**
    * 排序
    */
    private Byte ordernumber;
}
