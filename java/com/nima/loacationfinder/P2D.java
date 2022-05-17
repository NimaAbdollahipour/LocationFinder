package com.nima.loacationfinder;

public class P2D {
    protected double x;
    protected double y;
    public  P2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    public  P2D(){
    }
    @Override
    public String toString() {
        return "P2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public static P2D solve(P2D p1,P2D p2, P2D p3,double d1,double d2,double d3){
        P2D p=new P2D();
        p.x=(2*p3.y-2*p2.y)*(d1*d1-d3*d3+p3.x*p3.x+p3.y*p3.y-p1.x* p1.x-p1.y* p1.y);
        p.x=p.x+(2*p1.y-2*p3.y)*(d2*d2-d3*d3+p3.x*p3.x+p3.y*p3.y-p2.x* p2.x-p2.y* p2.y);
        p.x=p.x/((2*p3.y-2* p2.y)*(2*p3.x-2*p1.x)-(2*p3.y-2* p1.y)*(2*p3.x-2*p2.x));
        p.y=(2*p2.x-2*p3.x)*(d1*d1-d3*d3+p3.x*p3.x+p3.y*p3.y-p1.x* p1.x-p1.y* p1.y);
        p.y=p.y+(2*p3.x-2*p1.x)*(d2*d2-d3*d3+p3.x*p3.x+p3.y*p3.y-p2.x* p2.x-p2.y* p2.y);
        p.y=p.y/((2*p3.y-2* p2.y)*(2*p3.x-2*p1.x)-(2*p3.y-2* p1.y)*(2*p3.x-2*p2.x));
        return p;
    }
}
