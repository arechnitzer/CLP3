                  /*  File:  paraboloidGraphB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class paraboloidGraphB extends Template {

     static {templateClass = new paraboloidGraphB() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "paraboloidGraphB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0 ;    
          ysize = 3.0 ;  
          xmin = -3.0 ;
          xmax =  6.0 ;
          ymin = -3.0 ;
          ymax =  6.0 ;
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
          double al = 40 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double z0 = 0 ; 

          double xm = 2.5 ;
          double ym = 2.5 ;
          double zm = 4.5 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, xm,0,0) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fTeXlabel3d(0,0,zm+0.12, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.12,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;

         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
         String Black = "0 0 0 setrgbcolor  " ;

//          fEnv("lineWidth", 0.5) ;
//          fTeXlabel3d(0,2.5,0.1, "br", "$z=0$" ) ;
//          fLine3d(0,0,1, xm,0,1) ;
//          fLine3d(0,0,1, 0,ym,1) ;
//          fTeXlabel3d(0,2.5,1.1, "br", "$z=1$" ) ;
//          fLine3d(0,0,2, xm,0,2) ;
//          fLine3d(0,0,2, 0,ym,2) ;
//          fTeXlabel3d(0,2.5,2.1, "br", "$z=2$" ) ;
//          fLine3d(0,0,3, xm,0,3) ;
//          fLine3d(0,0,3, 0,ym,3) ;
//          fTeXlabel3d(0,2.5,3.1, "br", "$z=3$" ) ;
//          fLine3d(0,0,4, xm,0,4) ;
//          fLine3d(0,0,4, 0,ym,4) ;
//          fTeXlabel3d(0,2.5,4.1, "br", "$z=4$" ) ;

         double r = 0.07 ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         fEnv("lineWidth", 0.5) ;
         fDisk3d(0,0,4, r, r*aspect, FILLED) ;
         double C = 1 ;
         fCurve(new circ3d(al, 0.5,   0,0,3, C,0,0, 0,C,0),0,90,OPEN) ;
         C = Math.sqrt(2) ;
         fCurve(new circ3d(al, 0.5,   0,0,2, C,0,0, 0,C,0),0,90,OPEN) ;
         C = Math.sqrt(3) ;
         fCurve(new circ3d(al, 0.5,   0,0,1, C,0,0, 0,C,0),0,90,OPEN) ;
         C = 2 ;
         fCurve(new circ3d(al, 0.5,   0,0,0, C,0,0, 0,C,0),0,90,OPEN) ;


         canvas.append( new fPsWrite(Orange+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fCurve(new parabola3d(al, 0.5,   1,0),  0 , 2 ,OPEN) ;
         fCurve(new parabola3d(al, 0.5,   0,1),  0 , 2 ,OPEN) ;
         C = 2 ;
         fCurve(new circ3d(al, 0.5,   0,0,0, C,0,0, 0,C,0),0,90,OPEN) ;

     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*x0+y;
          double Y = x*x1+z ;
          fDisk(X,Y,r1,r2,TYPE) ;
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

//  The next class generates the curve z=4-t^2, x=at, y=bt

class parabola3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double a = 1 ;
     double b = 0 ;


   public parabola3d(double al, double projFactor, 
                                  double a, double b) {
        this.al = al ;
        this.a = a ;
        this.b = b ;
   }

     public double[] map(double t) {
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = a*t ;
          double y = b*t ;
          double z =4-t*t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}










