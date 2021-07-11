                  /*  File:  oddSymmetric.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class oddSymmetric extends Template {

     static {templateClass = new oddSymmetric() ; }

     public void setup() {
          filePrefix = "oddSymmetric" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.6 ;     
          ysize = 2.4*0.6 ;   
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -0.7 ;
          ymax = 1.7 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fCurve("[cos(t), sin(t)/1.5+0.5]", 1, 0, 2*Math.PI, CLOSED+FILLED) ;
          {fEnv("psFillGray", 0.4) ;
           double[] xlist = {0.3, 0.6, 0.6, 0.3} ;
           double[] ylist = {0.3, 0.3, 0.6, 0.6} ;
           fPolygon(xlist,ylist,4, FILLED) ;
           double[] xxlist = {-0.3, -0.6, -0.6, -0.3} ;
           fPolygon(xxlist,ylist,4, FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fDisk(0.45, 0.45, 0.03, 0.03, FILLED) ;
          fDisk(-0.45, 0.45, 0.03, 0.03, FILLED) ;
          fEnv("lineWidth", 0.3) ;
          double n = 10 ;
          double x = 0;
          double[] xi = {-1.2, -0.9, -0.6, -0.6, -0.3, 0.0, 0.3, 0.6, 0.9, 1.2} ;
          for (int i = 1; i<= n ; i++) {
               x = xi[i-1] ;
               fLine(x , -0.5, x, 1.4) ;
          }
          n = 6 ;
          double y = 0;
          double[] yi = {-0.3, 0.0, 0.3, 0.6, 0.9, 1.2} ;
          for (int i = 1; i<= n ; i++) {
               y = yi[i-1] ;
               fLine(-1.4 , y,  1.4, y) ;
          }
          fEnv("lineWidth", 0.6) ;
          fLine(xmin,0,xmax,0) ;
          fTeXlabel(xmax,-0.06,"tr","$x$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.04, ymax,"tr","$y$") ;
          fArrow(0.85, -0.75, 0.457, 0.436) ;
          fTeXlabel(0.85,-0.70,"tc","$(x_0,y_0)$") ;
          fArrow(-0.85, -0.75, -0.457, 0.436) ;
          fTeXlabel(-0.85,-0.70,"tc","$(-x_0,y_0)$") ;

     }
}
