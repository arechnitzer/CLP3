                  /*  File:  limits3dB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class limits3dB extends Template {

     static {templateClass = new limits3dB() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "limits3dB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.5*0.2 ;    
          ysize = 6.5*0.2 ;  
          xmin = -2.0 ;
          xmax =  5.0 ;
          ymin = -2.0 ;
          ymax =  5.0 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 30 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double xm = 5.0 ;
          double ym = 5.0 ;
          double zm = 5.0 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;

          fEnv("lineWidth", 1.0) ;
          fCurve(new paraC3d(al, 0.5,   0),0,2,OPEN)  ;
          fCurve(new paraC3d(al, 0.5,   4),0,2,OPEN)  ;
          fLine3d(0,4,4, 0,0,4) ;
          fLine3d(2,4,0, 2,0,0) ;
          fLine3d(2,4,0, 0,4,0) ;
          fLine3d(0,4,4, 0,4,0) ;
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

class paraC3d implements S2V {

     double al = 30 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double y = 0 ;

   public paraC3d(double al, double projFactor, double y) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.y = y ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double yy =  y ;
          double z =  4-t*t ;
          out[0] = x*x0+yy ;
          out[1] = x*x1+z;
          return out ;
   }
}








