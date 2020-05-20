                  /*  File:  OE06D_6a1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06D_6a1 extends Template {

     static {templateClass = new OE06D_6a1() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE06D_6a1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.5*0.5 ;    
          ysize = 6.5*0.5 ;  
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
          double xm = 2.4 ;
          double ym = 4.5 ;
          double zm = 2.2 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,1, 0,0,zm) ;
          fLine3d(0,4,0, 0,ym,0) ;
          fLine3d(1,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;

          fEnv("lineWidth", 0.5) ;

          fLine3d(1,0,0, 1,0,2) ;
          fLine3d(1,0,0, 1,4,0) ;
          fLine3d(1,0,2, 1,4,2) ;
          fLine3d(1,4,0, 1,4,2) ;
          fTeXlabel3d(1,2,2.1, "bc", "$x=1$") ;

          fLine3d(2,0,0, 0,4,0) ;
          fLine3d(2,0,0, 0,0,1) ;
          fLine3d(0,0,1, 0,4,0) ;


          fEnv("lineWidth", 1.5) ;

          fLine3d(0,0,1, 0,4,0) ;
          fLine3d(0,0,1, 1,0,0.5) ;
          fLine3d(1,0,0, 1,0,0.5) ;
          fLine3d(1,2,0, 1,0,0.5) ;
          fLine3d(1,0,0, 1,2,0) ;
          fLine3d(1,2,0, 0,4,0) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(0,0,0, 0,0,1) ;
          fLine3d(0,0,0, 0,4,0) ;
          fLine3d(0,0,0, 1,0,0) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;



          
          fTeXlabel3d(0,1.8,0.7, "bc", "$\\scriptstyle 2x+y+4z=4$") ;

          double r = 0.08 ;
          fEnv("psFillGray", 0.0) ;
          fDisk3d(0,0,1, r,r) ;
          fTeXlabel3d(0, 0.05, 1.05, "bl", "$\\scriptstyle (0,0,1)$") ;
          fDisk3d(0,4,0, r,r) ;
          fTeXlabel3d(0.05, 3.8, -0.1, "tl", "$\\scriptstyle (0,4,0)$") ;
          fDisk3d(2,0,0, r,r) ;
          fTeXlabel3d(2, -0.1, 0, "br", "$\\scriptstyle (2,0,0)$") ;
          fDisk3d(1,0,0.5, r,r) ;
          fTeXlabel3d(1, -0.1, 0.5, "br", "$\\scriptstyle (1,0,1/2)$") ;
          fDisk3d(1,2,0, r,r) ;
          fTeXlabel3d(1, 2.05, -0.1, "tl", "$\\scriptstyle (1,2,0)$") ;










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


}




