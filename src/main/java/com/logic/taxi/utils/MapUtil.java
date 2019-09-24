package com.logic.taxi.utils;

import java.util.Map;

/**
 * @Description
 * @author by sm
 * @Create 2018-04-17 11:09
 */

public class MapUtil {
    public static <K, V> K getFirstOrNull(Map<K, V> map) {
        K obj = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }
}
