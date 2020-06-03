package com.feelcode.tourism.base.utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 10:17 2020/6/3
 * @Modified By:
 */
public class OrderNoGenerateUtils {
    private static final String DATA_FORMAT_NYRSFM="yyyyMMddHHmmss";
    private static final String DATA_FORMAT_NYR="yyyyMMdd";

    public static String getOrderNoNYR(String prefix, Date date){
        return formatDate(date, DATA_FORMAT_NYR) + prefix + id(6);
    }

    private static String formatDate(Date originalDate, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(originalDate);
    }

    private final static char[] digits={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I',
            'G','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static String id(int size){
        SecureRandom random = new SecureRandom();
        char[] cs = new char[size];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = digits[random.nextInt(digits.length)];
        }
        return new String(cs);
    }
}
