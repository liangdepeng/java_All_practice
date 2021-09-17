package ldp;


import ldp.utils.SystemOutputUtils;

import java.math.BigDecimal;

public class JavaTest {
    public static void main(String[] args) {

        SystemOutputUtils.println(Byte.MAX_VALUE);//  Math.pow(2,7)-1
        SystemOutputUtils.println(Byte.MIN_VALUE);// -Math.pow(2,7)

        SystemOutputUtils.println(Short.MAX_VALUE);//  Math.pow(2,15)-1
        SystemOutputUtils.println(Short.MIN_VALUE);// -Math.pow(2,15)

        SystemOutputUtils.println(Integer.MAX_VALUE);//  Math.pow(2,31)-1
        SystemOutputUtils.println(Integer.MIN_VALUE);// -Math.pow(2,31)

        SystemOutputUtils.println(Long.MAX_VALUE);//  Math.pow(2,63)-1
        SystemOutputUtils.println(Long.MIN_VALUE);// -Math.pow(2,63)

        SystemOutputUtils.println(Float.MAX_VALUE);
        SystemOutputUtils.println(Float.MIN_VALUE);


        SystemOutputUtils.println(Double.MIN_VALUE);//  Math.pow(2,-1074)
        SystemOutputUtils.println(Double.MAX_VALUE);

        SystemOutputUtils.println(numberFormat(Long.MAX_VALUE));

        SystemOutputUtils.println(Math.pow(2, Integer.MIN_VALUE));
    }


    private static String numberFormat(long value) {
        if (value < 10000) {
            return String.valueOf(value);
        }
        BigDecimal bigDecimal = new BigDecimal(value).divide(new BigDecimal(10000), BigDecimal.ROUND_UP);
        // BigDecimal bigDecimal = new BigDecimal((double) value / 10000);
        return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "w";
    }
}
