package com.nima.loacationfinder;

public class P3D {
    protected double x;
    protected double y;
    protected double z;
    public P3D(){
    }
    public P3D(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    @Override
    public String toString() {
        return "P3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
    public static P3D solve(P3D p1,P3D p2,P3D p3,P3D p4,double d1,double d2, double d3,double d4){
        P3D p=new P3D();
        double[]R={d1*d1-d4*d4+p4.x*p4.x+p4.y*p4.y+p4.z*p4.z-(p1.x*p1.x+p1.y*p1.y+p1.z*p1.z),
                d2*d2-d4*d4+p4.x*p4.x+p4.y*p4.y+p4.z*p4.z-(p2.x*p2.x+p2.y*p2.y+p2.z*p2.z),
                d3*d3-d4*d4+p4.x*p4.x+p4.y*p4.y+p4.z*p4.z-(p3.x*p3.x+p3.y*p3.y+p3.z*p3.z)};
        double[][]F={{2* p4.x-2*p1.x,2* p4.y-2*p1.y,2* p4.z-2*p1.z},{2* p4.x-2*p2.x,2* p4.y-2*p2.y,2* p4.z-2*p2.z}
        ,{2* p4.x-2*p3.x,2* p4.y-2*p3.y,2* p4.z-2*p3.z}};
        F= Invert.invert3x3(F);
        p.x=F[0][0]*R[0]+F[0][1]*R[1]+F[0][2]*R[2];
        p.y=F[1][0]*R[0]+F[1][1]*R[1]+F[1][2]*R[2];
        p.z=F[2][0]*R[0]+F[2][1]*R[1]+F[2][2]*R[2];
        return p;
    }
}
