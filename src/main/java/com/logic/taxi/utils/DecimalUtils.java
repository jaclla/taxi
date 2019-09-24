package com.logic.taxi.utils;

import java.math.BigDecimal;

/**
 * 尾数处理
 *
 * @author Summer
 */
public class DecimalUtils {
    /**
     * 四舍五入到分
     */
    public final static int HALF_UP_FEN = 1;
    /**
     * 四舍五入到角
     */
    public final static int HALF_UP_JIAO = 2;
    /**
     * 四舍五入到元
     */
    public final static int HALF_UP_YUAN = 3;
    /**
     * 见分进角
     */
    public final static int UP_JIAO = 4;
    /**
     * 见分舍去，见角进元
     */
    public final static int DOWN_FEN_UP_JIAO = 5;
    /**
     * 见厘进分
     */
    public final static int UP_FEN = 6;
    /**
     * 见角舍去
     */
    public final static int DOWN_JIAO = 7;
    /**
     * 见厘舍去
     */
    public final static int DOWN_LI = 8;
    /**
     * 四舍五入到厘
     */
    public final static int HALF_UP_LI = 9;
    /**
     * 四舍五入到小数点后四位
     */
    public final static int HALF_UP_FOUR = 10;

    /**
     * 真实数字除以10000然后保留2位小数
     */
    public final static int HALF_UP_DIVIDE_10000_TWO = 11;


    public static BigDecimal format(BigDecimal rmb, Integer mode) {
        switch (mode) {
            case HALF_UP_FEN:
                return rmb.setScale(2, BigDecimal.ROUND_HALF_UP);
            case HALF_UP_JIAO:
                return rmb.setScale(1, BigDecimal.ROUND_HALF_UP);
            case HALF_UP_YUAN:
                return rmb.setScale(0, BigDecimal.ROUND_HALF_UP);
            case HALF_UP_LI:
                return rmb.setScale(3, BigDecimal.ROUND_HALF_UP);
            case HALF_UP_FOUR:
                return rmb.setScale(4, BigDecimal.ROUND_HALF_UP);
            case UP_JIAO:
                return rmb.setScale(1, BigDecimal.ROUND_UP);
            case DOWN_FEN_UP_JIAO:
                rmb = rmb.setScale(1, BigDecimal.ROUND_DOWN);
                return rmb.setScale(0, BigDecimal.ROUND_UP);
            case UP_FEN:
                return rmb.setScale(2, BigDecimal.ROUND_UP);
            case DOWN_JIAO:
                return rmb.setScale(0, BigDecimal.ROUND_DOWN);
            case DOWN_LI:
                return rmb.setScale(2, BigDecimal.ROUND_DOWN);
            case HALF_UP_DIVIDE_10000_TWO:
                return rmb.divide(new BigDecimal(10000)).setScale(4, BigDecimal.ROUND_HALF_UP);
            default:
                break;
        }
        return rmb;
    }

}
