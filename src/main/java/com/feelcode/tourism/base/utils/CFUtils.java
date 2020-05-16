package com.feelcode.tourism.base.utils;

import java.text.DecimalFormat;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 16:28 2020/5/16
 * @Modified By:
 */
public class CFUtils {

    public static double cosineSimilarity(double[] A, double[] B){
        if(A.length!=B.length){
            return 0.0000;
        }
        if(A==null||B==null){
            return 0.0000;
        }
        long fenzi=0;
        for(int i=0;i<A.length;i++){
            fenzi+=A[i]*B[i];
        }
        long left=0;
        long right=0;
        for(int i=0;i<A.length;i++){
            left+=A[i]*A[i];
            right+=B[i]*B[i];
        }
        if(left*right==0){
            return 0.0000;
        }
        double result=fenzi/Math.sqrt(left*right);
        DecimalFormat df=new DecimalFormat("#.####");
        return Double.parseDouble(df.format(result));
    }

}
