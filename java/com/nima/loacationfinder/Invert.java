package com.nima.loacationfinder;

public class Invert {
    public static double[][] invert3x3(double a[][]) {
        double Det;
        double[][]b=new double[3][3];
        b[0][0]=a[1][1]*a[2][2]-a[1][2]*a[2][1];
        b[0][1]=a[0][2]*a[2][1]-a[2][2]*a[0][1];
        b[0][2]=a[0][1]*a[1][2]-a[0][2]*a[1][1];
        b[1][0]=a[2][0]*a[1][2]-a[2][2]*a[1][0];
        b[1][1]=a[0][0]*a[2][2]-a[0][2]*a[2][0];
        b[1][2]=a[0][2]*a[1][0]-a[0][0]*a[1][2];
        b[2][0]=a[1][0]*a[2][1]-a[1][1]*a[2][0];
        b[2][1]=a[0][1]*a[2][0]-a[0][0]*a[2][1];
        b[2][2]=a[0][0]*a[1][1]-a[0][1]*a[1][0];
        Det=a[0][0]*b[0][0]+a[0][1]*b[1][0]+a[0][2]*b[2][0];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++) {
                if(Det!=0)
                b[i][j] = b[i][j] / Det;
                else b[i][j]=0;
            }
//        for(int i=0;i<3;i++)
//            for(int j=0;j<3;j++) {
//                    b[i][j] = b[j][i];
//            }
        return b;
    }
}
