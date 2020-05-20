                  /*  File:  intDecomp2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class intDecomp2 extends Template {

     static {templateClass = new intDecomp2() ; }

     public void setup() {
          filePrefix = "intDecomp2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;     
          ysize = 1.8 ;   
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -1.5 ;
          ymax = 1.5 ;
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
          fCurve("[cos(t), cos(t)/4+sin(t)/1.5]", 1, 0, 2*Math.PI, CLOSED+FILLED) ;
          {fEnv("psFillGray", 0.3) ;
           double[] xlist = {0.1, 0.4, 0.4, 0.1} ;
           double[] ylist = {0.0, 0.0,-0.3,-0.3} ;
           fPolygon(xlist,ylist,4, FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fDisk(0.3, -0.2, 0.03, 0.03, FILLED) ;
          fEnv("lineWidth", 0.3) ;
          double n = 8 ;
          double x = 0;
          double[] xi = {-1.1, -0.8, -0.5, -0.3, 0.1, 0.4, 0.7, 1.2} ;
          for (int i = 1; i<= n ; i++) {
               x = xi[i-1] ;
               fLine(x , ymin+0.5,   x, ymax-0.5) ;
          }
          n = 6 ;
          double y = 0;
          double[] yi = {-0.8, -0.5, -0.3, 0.2, 0.4, 0.8} ;
          for (int i = 1; i<= n ; i++) {
               y = yi[i-1] ;
               fLine(xmin+0.2 , y,  xmax-0.2, y) ;
          }
          fEnv("lineWidth", 0.6) ;
          fArrow(xmin,0,xmax,0) ;
          fTeXlabel(xmax,-(ymax-ymin)/25.0,"tr","$x$") ;
          fArrow(0, ymin, 0, ymax) ;
          fTeXlabel(-(xmax-xmin)/25.0, ymax,"tr","$y$") ;
          fArrow(0.62, -1.3, 0.32, -0.25) ;
          fTeXlabel(0.63,-1.3,"tl","$(x_{13}^*,y_{13}^*)$") ;

     }
}
