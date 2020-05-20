                  /*  File:  xchange6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xchange6 extends Template {

     static {templateClass = new xchange6() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "xchange6" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.5*0.6 ;    
          ysize = 6.5*0.6 ;  
          xmin = -2.0 ;
          xmax =  5.0 ;
          ymin = -2.0 ;
          ymax =  5.0 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 50 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double xm = 2.2 ;
          double ym = 2.8 ;
          double zm = 2.4 ;
          double rr = 0.06 ; 

          double Z = 0.8 ;
          double X = 0.8*Z ; double Y = 2-Z ;
          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = { 0, 0,  X, 1.6} ;
             double[] ylist = { 0, Y,  Y,   0} ;
             double[] zlist = { Z, Z,  Z,   Z} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;

          {  double[] xlist = { 0, 0,  X, 1.6} ;
             double[] ylist = { 0, Y,  Y,   0} ;
             double[] zlist = { Z, Z,  Z,   Z} ;
             fPolygon3d(xlist, ylist, zlist, 4, CLOSED) ; }


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.0) ;
//          fDisk3d(  0, 0, Z , rr, rr, FILLED) ;
          fDisk3d(1.6, 0, Z, rr, rr, FILLED) ;
          fDisk3d(  X, Y, Z, rr, rr, FILLED) ;
          fDisk3d(  0, Y, Z, rr, rr, FILLED) ;
          fTeXlabel3d(1.6,-0.1,Z, "cr", "$(1,0,Z)$") ;
          fTeXlabel3d( 0, Y, Z, "bl", "$(0,2-Z,Z)$") ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow3d(X, Y+0.3, -0.3,  X, Y, Z-0.05) ;
          fTeXlabel3d( X, Y+0.3, -0.3, "tl", "$(Z/2,2-Z,Z)$") ;



          {  double[] xlist = { 0, 1.6, 1.6, 0} ;
             double[] ylist = { 0,   0,   0, 0} ;
             double[] zlist = { 0,   0,   2, 2} ;
             fPolygon3d(xlist, ylist, zlist, 4, CLOSED) ; }
          fLine3d(  0,0, 2, 0,2,0) ;
          fLine3d(1.6,0, 0, 0,2,0) ;
          fLine3d(1.6,0, 2, 0,2,0) ;


          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;



//          fEnv("lineWidth", 1.5) ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fCurve(new paraC3d(al, 0.5,   0),0,2,OPEN)  ;
//          fCurve(new paraPlaneC3d(al, 0.5),0,2,OPEN)  ;
//          fLine3d(0,4,4, 0,0,4) ;
//          fLine3d(0,4,4, 0,4,0) ;
//          fLine3d(0,0,0, 0,4,0) ;
//          fLine3d(0,0,0, 0,0,4) ;
//          fLine3d(2,2,0, 2,0,0) ;
//          fLine3d(2,2,0, 0,4,0) ;
//          fLine3d(2,0,0, 0,0,0) ;

//          fEnv("lineWidth", 0.5) ;
//          fEnv("psFillGray", 0.0) ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//          double rr = 0.1 ;
//          fDisk3d(2,2,0, rr, rr, FILLED) ;
//          fTeXlabel3d(2.6,2.4,0, "ct", "$(2,2,0)$") ;
//          fDisk3d(x,4-x,4-x*x, rr, rr, FILLED) ;
//          fTeXlabel3d(0.3, 4.8, 3.5, "cl", "$(x,4-x,4-x^2)$") ;
//          fTeXlabel3d(0, 4.1, 2, "lc", "$y=4-x$") ;
//          fTeXlabel3d(0, 2,4.1, "bc", "$z=4-x^2$") ;






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
                         double r1, double r2, long TYPE) {
          double X = x*x0+y;
          double Y = x*x1+z;
          fDisk(X,Y,r1,r2,TYPE) ;
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


class paraPlaneC3d implements S2V {

     double al = 30 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection

   public paraPlaneC3d(double al, double projFactor) {
        this.al = al ;
        this.projFactor = projFactor ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double y = 4-x ;
          double z =  4-t*t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}








