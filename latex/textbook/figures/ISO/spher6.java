                  /*  File:  spher6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class spher6 extends Template {

     static {templateClass = new spher6() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "spher6" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5 ;    
          ysize = 3.5 ;  
          xmin = -70 ;
          xmax =  90 ;
          ymin = -70 ;
          ymax =  90 ;
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
          double a = 65 ;
          double r1 = 50 ;
          double r2 = 80 ;
          double th2 = 70 ;
          double phi1 = 50 ;
          double phi2 = 70 ;
          double xm = 80 ;
          double ym = 80 ;
          double zm = 90 ;


          fEnv("lineWidth", 0.4) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;


          // th2, phi1
          double xh = Math.cos(th2*Math.PI/180);
          double yh = Math.sin(th2*Math.PI/180);
          double xv = Math.sin(phi1*Math.PI/180);
          double zv = Math.cos(phi1*Math.PI/180);
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r1, r1*xh,r1*yh,0),
                 0,90,OPEN)  ;
          fLine3d(0,0,0, r2*xh,r2*yh,0) ;
          fLine3d(0,0,0, r2*xh*xv,r2*yh*xv,r2*zv) ;
          // th2, phi2
          xv = Math.sin(phi2*Math.PI/180);
          zv = Math.cos(phi2*Math.PI/180);
          fLine3d(0,0,0, r2*xh*xv,r2*yh*xv,r2*zv) ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          // th2, phi1
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 phi1,phi2,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r1, r1*xh,r1*yh,0),
                 phi1,phi2,OPEN)  ;
          xv = Math.sin(phi1*Math.PI/180);
          zv = Math.cos(phi1*Math.PI/180);
          fLine3d(r1*xh*xv,r1*yh*xv,r1*zv, r2*xh*xv,r2*yh*xv,r2*zv) ;
          // th2, phi2
          xv = Math.sin(phi2*Math.PI/180);
          zv = Math.cos(phi2*Math.PI/180);
          fLine3d(r1*xh*xv,r1*yh*xv,r1*zv, r2*xh*xv,r2*yh*xv,r2*zv) ;

//          fLine3d(r1*xh,r1*yh,0, r2*xh,r2*yh,0) ;
//          fTeXlabel3d( (r1+r2)*xh/2,(r1+r2)*yh/2-2,-2, "tc", "$\\dee{\\rho}$") ;


          xh = Math.cos(th2*Math.PI/180);
          yh = Math.sin(th2*Math.PI/180);
          xv = Math.sin((phi1+phi2)*Math.PI/360);
          zv = Math.cos((phi1+phi2)*Math.PI/360);
          fTeXlabel3d(r2*xh*xv,r2*yh*xv+2,r2*zv, "lc", "$\\,r\\,\\dee{\\theta}$") ;


          fTeXlabel(5,8, "bc", "$\\theta$") ;
          fTeXlabel(22,8, "bc", "$\\dee{\\theta}$") ;
          fTeXlabel(53,5, "bc", "$\\dee{r}$") ;
//          fTeXlabel(2.5,-2, "tc", "$\\phi$") ;



          
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
        this.xa = r ; ;
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
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}



