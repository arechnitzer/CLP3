                  /*  File:  OE06D_6a4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06D_6a4 extends Template {

     static {templateClass = new OE06D_6a4() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE06D_6a4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.5*0.7 ;    
          ysize = 6.5*0.7 ;  
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
          double xm = 1.4 ;
          double ym = 4.5 ;
          double zm = 1.4 ;

          double Y = 0.5 ; double Z1 = (4-Y)/4.0 ; double Z2 = (4-2-Y)/4.0 ;
          fEnv("psFillGray", 0.8) ;
          {  double[] xlist = {0,  1, 1,  0} ;
             double[] ylist = {Y,  Y, Y,  Y} ;
             double[] zlist = {0,  0, Z2, Z1 } ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }

          Y = 2.5 ;  double X =  (4-Y)/2.0 ; Z1 = (4-Y)/4.0 ;
          {  double[] xlist = {0,  X,  0} ;
             double[] ylist = {Y,  Y,  Y} ;
             double[] zlist = {0,  0, Z1 } ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,1, 0,0,zm) ;
          fLine3d(0,4,0, 0,ym,0) ;
          fLine3d(1,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;

          fEnv("lineWidth", 0.5) ;

//          fLine3d(1,0,0, 1,0,2) ;
//          fLine3d(1,0,0, 1,4,0) ;
//          fLine3d(1,0,2, 1,4,2) ;
//          fLine3d(1,4,0, 1,4,2) ;
          fTeXlabel3d(1,1.3,-0.05, "tc", "$\\scriptstyle x=1$") ;

//          fLine3d(2,0,0, 0,4,0) ;
//          fLine3d(2,0,0, 0,0,1) ;
//          fLine3d(0,0,1, 0,4,0) ;


          fEnv("lineWidth", 1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;

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

          fEnv("lineWidth", 0.5) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(1,2,0, 0,2,0) ;
          fLine3d(0,2,0, 0,2,0.5) ;
          fLine3d(1,2,0, 0,2,0.5) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          
          fTeXlabel3d(0,1.8,0.7, "bc", "$\\scriptstyle z=(4-2x-y)/4$") ;

          double r = 0.05 ;
          fEnv("psFillGray", 0.0) ;
          fDisk3d(0,0,1, r,r) ;
          fTeXlabel3d(0, 0.05, 1.05, "bl", "$\\scriptstyle (0,0,1)$") ;
          fDisk3d(0,4,0, r,r) ;
          fTeXlabel3d(0.05, 3.8, -0.1, "tl", "$\\scriptstyle (0,4,0)$") ;
          fDisk3d(1,0,0, r,r) ;
          fTeXlabel3d(1, -0.1, 0, "br", "$\\scriptstyle (1,0,0)$") ;
          fDisk3d(1,0,0.5, r,r) ;
          fTeXlabel3d(1, -0.1, 0.5, "br", "$\\scriptstyle (1,0,1/2)$") ;
          fDisk3d(1,2,0, r,r) ;
          fTeXlabel3d(1, 2.05, -0.1, "tc", "$\\scriptstyle (1,2,0)$") ;

          fEnv("psFillGray", 0.6) ;
          Y = 0.5 ; 
          fDisk3d(1,Y,0, r,r) ;
          fTeXlabel3d(1, Y+.05, -0.1, "tc", "$\\scriptstyle (1,y,0)$") ;
          Y = 2.5 ;  X =  (4-Y)/2.0 ;
          fDisk3d(X,Y,0, r,r) ;
          fTeXlabel3d(X, Y-0.1, -0.1, "tl", 
                  "$\\scriptstyle (\\,(4-y)/2\\,,\\,y\\,,\\,0)$") ;


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




