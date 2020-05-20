                  /*  File:  distance.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class distance extends Template {

     static {templateClass = new distance() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "distance" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 2.5 ;  
          xmin = -1.2 ;
          xmax =  3.8 ;
          ymin = -1.5 ;
          ymax =  3.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = -0.2 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 60 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double z0 = 0 ; double X = 0 ; double Y = 0 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double xm = 3.3 ;
          double ym = 2.0 ;
          double zm = 2.6 ;

          double a = 0.3 ;
          double b = 0.6 ;
          double Z = 2.3 ;  double XZ = Math.sqrt(Z/a) ; double YZ = Math.sqrt(Z/b) ;
                         double XXZ = Math.sqrt(Z/a/2) ; double YYZ = Math.sqrt(Z/b/2) ;

          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = {0, XZ, XXZ, 0} ;
             double[] ylist = {0, 0,  YYZ, YZ} ;
             double[] zlist = {Z, Z,    Z,  Z} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }
          fCurve(new circ3d(al, 0.5,   0,0,Z, XZ,0,0, 0,YZ,0),
                 0,90,FILLED) ;



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.08, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.08,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;

          fLine3d(0,0,Z, XZ,0,Z) ;
          fLine3d(0,0,Z,  0,YZ,Z) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine3d(0,0,0, 0,0,1.2) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(0,0,1.2, 0,0,zm) ;



          fEnv("lineWidth", 2.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve(new parabola3d(al, 0.5,   a,b,0),
                 0,XZ,OPEN) ;
          fCurve(new parabola3d(al, 0.5,   a,b,90),
                 0,YZ,OPEN) ;
          fCurve(new circ3d(al, 0.5,   0,0,Z, XZ,0,0, 0,YZ,0),
                 0,90,OPEN) ;
          double y3 = 1.6 ; double z3 = b*y3*y3 ;
          fTeXlabel3d(0,y3+0.09,z3, "cl", "$z=x^2+y^2$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;

          double r = 0.07 ;
          double x1 = 2.6 ;  double x2 = 1.6 ; double z2 = a*x2*x2 ;
          fEnv("lineWidth", 1.0) ;
          fDisk3d(x1,0,0, r,r*aspect) ;
                    fTeXlabel3d(x1,-0.1,0, "br", "$(3,0,0)$") ;
          fDisk3d(x2,0,z2, r,r*aspect) ;
                    fTeXlabel3d(x2,-0.15,z2, "cr", "$(a,b,a^2+b^2)$") ;
          fLine3d(x1,0,0, x2,0,z2) ;


 
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double rx, double ry) {
          double X = x*x0+y ;
          double Y = x*x1+z ;

          fDisk(X, Y, rx, ry, FILLED) ;
     }

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*x0+ylist[i] ;
               yy[i] = xlist[i]*x1+zlist[i] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }



}




class circ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = r ; 
        this.ya = 0 ;
        this.za = 0 ;
        this.xb = 0 ;
        this.yb = r ;
        this.zb = 0 ;
   }


   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = xa ;
        this.ya = ya ;
        this.za = za ;
        this.xb = xb ;
        this.yb = yb ;
        this.zb = zb ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}

//  The next class generates the curve 
//           x = t\cos\th 
//           y = t\sin\th
//           z=a(\cos\th t)^2+b(\sin\th t)^2 but with 

class parabola3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double a  = 1 ;
     double b = 1 ;
     double th = 90 ;
     double cth = 0 ;
     double sth = 1 ;


   public parabola3d(double al, double projFactor, 
                 double a, double b, double th) {
        this.al = al ;
        this.a = a ;
        this.b = b ;
        this.th = th ;
        cth = Math.cos(th*Math.PI/180.0) ;
        sth = Math.sin(th*Math.PI/180.0) ;
   }

     public double[] map(double t) {
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t*cth;
          double y = t*sth ;
          double z = a*x*x+b*y*y ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}



