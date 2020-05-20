                  /*  File:  pmidGraphB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pmidGraphB extends Template {

     static {templateClass = new pmidGraphB() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "pmidGraphB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;    
          ysize = 1.2 ;  
          xmin = -8 ;
          xmax =  8 ;
          ymin = -3 ;
          ymax =  12 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = -0.2 ;   // in inches
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
          double xm = 8 ;
          double ym = 8 ;
          double zm = 10 ;
          double X = 8 ;
          double Y = 6 ;
          double Z = 8 ;

          fEnv("lineWidth", 0.5) ;
//          fLine3d(0,0,-1, 0,0,zm) ;
//          fLine3d(0,-1,0, 0,ym,0) ;
//          fLine3d(-1,0,0, xm,0,0) ;
//          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
//          fTeXlabel3d(0,ym+0.2,0, "cl", "$y$") ;
//          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;

         fEnv("psFillGray", 0.8) ;
         {double[] xlist = {X,  0,  -X, 0} ;
          double[] ylist = {0,  Y,   0, -Y} ;
          double[] zlist = {Z,  Z,   Z, Z} ;
          fPolygon3d(xlist,ylist, zlist, 4, FILLED) ;}


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          double F = 0.53 ;
          fLine3d(0,0,0, 0,Y,Z) ;
          fLine3d(0,0,0, X,0,Z) ;
          fLine3d(-X,0,Z, -F*X,0,F*Z) ;
          fLine3d(0,0,0, 0,-Y,Z) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine3d(0,0,0, -F*X,0,F*Z) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fLine3d(X,0,Z, 0,Y,Z) ;
          fLine3d(-X,0,Z, 0,Y,Z) ;
          fLine3d(-X,0,Z, 0,-Y,Z) ;
          fLine3d(X,0,Z, 0,-Y,Z) ;
//          fLine3d(0,0,8, 0,6,8) ;
//          fLine3d(0,0,8, 8,0,8) ;


          
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






