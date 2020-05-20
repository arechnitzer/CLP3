                  /*  File:  xchange5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xchange5 extends Template {

     static {templateClass = new xchange5() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "xchange5" ;  
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
          double xm = 2.0 ;
          double ym = 2.2 ;
          double zm = 2.2 ;
          double rr = 0.06 ; 

          double Ym = 0.7 ;
          double Xm = 0.8*(2-Ym) ; double Zm = 2-Ym ;
          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = { 0, Xm,  Xm,  0} ;
             double[] ylist = {Ym, Ym,  Ym, Ym} ;
             double[] zlist = { 0,  0,  Zm, Zm} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;

          Ym = 0.7 ;
          Xm = 0.8*(2-Ym) ;  Zm = 2-Ym ;
          {  double[] xlist = { 0, Xm,  Xm,  0} ;
             double[] ylist = {Ym, Ym,  Ym, Ym} ;
             double[] zlist = { 0,  0,  Zm, Zm} ;
             fPolygon3d(xlist, ylist, zlist, 4, CLOSED) ; }
          fEnv("psFillGray", 0.0) ;
          fDisk3d(Xm,Ym, 0, rr, rr, FILLED) ;
          fTeXlabel3d(Xm,Ym-0.1, -0.1, "tl", 
                     "$\\big(\\frac{2-Y}{2},Y,0\\big)$") ;
//          fTeXlabel3d(Xm,Ym-0.1, -0.1, "tl", 
//                     "$\\Big(\\displaystyle\\frac{2-y_0}{2},y_0,0\\Big)$") ;
//          fTeXlabel3d(Xm,Ym-0.1, -0.1, "tl", 
//                     "$\\big(1-\\nicefrac{y_0}{2}\\,,\\,y_0\\,,\\,0\\big)$") ;
//          fTeXlabel3d(Xm,Ym-0.1, -0.1, "tl", 
//                     "$\\big(1-y_0/2\\,,\\,y_0\\,,\\,0\\big)$") ;
          fDisk3d( 0,Ym,Zm, rr, rr, FILLED) ;
          fTeXlabel3d(0,Ym-0.4, Zm+0.05, "bl", 
                     "$\\big(0,Y,2-Y\\big)$") ;



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          double Ymm = 0.3 ;
          fLine3d(0,0,0, 0,Ymm,0) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine3d(0,Ymm,0, 0,Ym,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(0,Ym,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;

//          fEnv("headHalfWidth", 2.0*1.2) ;
//          fEnv("headLength", 6.0*1.2) ;
//          fArrow3d(0.3, 4.75, 3.5,  x,4-x+0.1,4-x*x) ;
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








