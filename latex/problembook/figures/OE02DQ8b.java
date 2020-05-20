                  /*  File:  OE02DQ8b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE02DQ8b extends Template {

     static {templateClass = new OE02DQ8b() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE02DQ8b" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0 ;    
          ysize = 4.0 ;  
          xmin = -3 ;
          xmax =  4 ;
          ymin = -3 ;
          ymax =  4 ;
          topmargin = -0.5 ;   // in inches
          bottommargin = -0.8 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double xm = 2.3 ;
          double ym = 2.3 ;
          double zm = 2.3 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.02,-0.02, "tr", "$x$") ;

          fCurve(new curv3d(al, 0.5,   2, 0),
                 0,1,OPEN)  ;
          fLine3d(0,0,2,  2,0,2) ;
          fLine3d(0,0,2,  0,2,2) ;
          fLine3d(0,2,2,  2,0,2) ;
          fLine3d(0,2,2,  0,2,0) ;
          fLine3d(2,0,0,  2,0,2) ;
          fLine3d(0,2,0,  2,0,0) ;
          fLine3d(2,1,0,  0,1,0) ;
          fLine3d(2,1,0,  2,0,0) ;

          fEnv("lineWidth", 1.5) ;
          fCurve(new curv3d(al, 0.5,   0, 0),
                 0,1,OPEN)  ;
          fCurve(new curv3d(al, 0.5,   0,1),
                 0,1,OPEN)  ;
          fLine3d(0,0,1,  0,0,0) ;
          fLine3d(0,1,0,  0,0,0) ;
          fLine3d(2,0,0,  0,0,0) ;
          fLine3d(2,0,1,  0,0,1) ;
          fLine3d(0,1,0,  1,1,0) ;
          fLine3d(2,0,0,  1,1,0) ;
          fLine3d(2,0,0,  2,0,1) ;


          fTeXlabel3d(0,0.3,1.2, "bl", "$x+y=2$") ;        
          fTeXlabel3d(2,1,0, "tl", "$y^2+z^2=1$") ;        
     
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

}


class curv3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double xa = 0 ;
     double xb = 0 ;

     public curv3d(double al, double projFactor, double xa, double xb) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.xa = xa ;
        this.xb = xb ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double y = t ;
          double z = Math.sqrt(1-t*t) ;
          double x = xa+xb*(2-y) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




