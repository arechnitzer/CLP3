                  /*  File:  cylTh0.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cylTh0 extends Template {

     static {templateClass = new cylTh0() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "cylTh0" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -75 ;
          ymax =  80 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 65 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r = 100 ;
          double th = 0 ; 
          double c = Math.cos(th*Math.PI/180) ;
          double s = Math.sin(th*Math.PI/180) ;
          double zt = 70 ;
          double zb = -30 ;
          double xm = 130 ;
          double ym = 60 ;
          double zm = 80 ;



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(r,0,0,  xm, 0,0) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine3d(0,0,0,  r,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-1, xm*x1-1, "tr", "$x$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine3d(0,0,zb, 0,0, zt) ;
          fLine3d(0,0,zt, r*c,r*s,zt) ;
          fLine3d(0,0,zb, r*c,r*s,zb) ;
          fLine3d(r*c,r*s,zb, r*c,r*s,zt) ;
          fTeXlabel3d(r/2,4,zb, "cl", "$\\theta=0$") ;


          
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


class circ3d implements S2V {

     double al = 45 ;
     double a = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double r = 50.0 ;

   public circ3d(double al, double a, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.a = a ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.r  = r ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+r*Math.cos(t*Math.PI/180) ;
          double y = cy+r*Math.sin(t*Math.PI/180) ;
          double z = cz ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}



