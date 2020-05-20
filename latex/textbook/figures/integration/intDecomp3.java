                  /*  File:  intDecomp3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class intDecomp3 extends Template {

     static {templateClass = new intDecomp3() ; }

     public void setup() {
          filePrefix = "intDecomp3" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;     
          ysize = 1.5 ;   
          xmin = -0.1 ;
          xmax = 2.1 ;
          ymin = -0.1 ;
          ymax = 2.1 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.8) ;
          double n = 7 ;
          double x = 0;
          double[] xi = {0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6} ;
          for (int i = 1; i<= n ; i++) {
               x = xi[i-1] ;
               fLine(x , 0.2,   x, 1.8) ;
          }
          n = 7 ;
          double y = 0;
          double[] yi = {0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6} ;
          for (int i = 1; i<= n ; i++) {
               y = yi[i-1] ;
               fLine(0.2 , y, 1.8, y) ;
          }
          fEnv("lineWidth", 0.5) ;
          fArrow(xmin,0,xmax,0) ;
          fTeXlabel(xmax,-(ymax-ymin)/25.0,"tr","$x$") ;
          fArrow(0, ymin, 0, ymax) ;
          fTeXlabel(-(xmax-xmin)/25.0, ymax,"tr","$y$") ;

     }
}
