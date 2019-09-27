package com.logic.taxi.entity;

import com.logic.taxi.controller.BaseController;
import lombok.Data;

@Data
public class SysDictionaryType  {
    private Integer id;

    /**
    * 字典类型名称
    */
    private String name;

    /**
    * 编码
    */
    private String code;
}
