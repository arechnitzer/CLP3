                  /*  File:  limits3dE.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class limits3dE extends Template {

     static {templateClass = new limits3dE() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "limits3dE" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.5*0.4 ;    
          ysize = 6.5*0.4 ;  
          xmin = -2.0 ;
          xmax =  5.0 ;
          ymin = -2.0 ;
          ymax =  5.0 ;
          topmargin = 0.3 ;   // in inches
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

          double z = 2 ;
          double x = Math.sqrt(4-z) ;
          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = { 0,     x,    x,  0} ;
             double[] ylist = { 0,     0,  4-x,  4} ;
             double[] zlist = { z,     z,    z,  z} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;

          fEnv("lineWidth", 1.0) ;
          fLine3d(0,0,z, 0,4,z) ;
          fLine3d(0,0,z, x,0,z) ;
          fLine3d(x,0,z, x,4-x,z) ;
          fLine3d(0,4,z, x,4-x,z) ;

          fEnv("lineWidth", 1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new paraC3d(al, 0.5,   0),0,2,OPEN)  ;
          fCurve(new paraPlaneC3d(al, 0.5),0,2,OPEN)  ;
          fCurve(new paraC3d(al, 0.5,   0),0,2,OPEN)  ;
          fCurve(new paraPlaneC3d(al, 0.5),0,2,OPEN)  ;
          fLine3d(0,4,4, 0,0,4) ;
          fLine3d(0,4,4, 0,4,0) ;
          fLine3d(0,0,0, 0,4,0) ;
          fLine3d(0,0,0, 0,0,4) ;
          fLine3d(2,2,0, 2,0,0) ;
          fLine3d(2,2,0, 0,4,0) ;
          fLine3d(2,0,0, 0,0,0) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.0) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double rr = 0.1 ;
          fDisk3d(0,4,4, rr, rr, FILLED) ;
          fTeXlabel3d(0,4.2,4, "lc", "$(0,4,4)$") ;
          fDisk3d(x,0,z, rr, rr, FILLED) ;
          fTeXlabel3d(x,-0.2,z, "rc", "$(\\sqrt{4-z},0,z)$") ;
          fTeXlabel3d(0, 4.1, 2.5, "lc", "$y=4-x$") ;
          fTeXlabel3d(0, 2,4.1, "bc", "$x=\\sqrt{4-z}$") ;






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








