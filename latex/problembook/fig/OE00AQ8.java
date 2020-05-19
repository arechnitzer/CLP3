                  /*  File:  OE00AQ8.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE00AQ8 extends Template {

     static {templateClass = new OE00AQ8() ; }

     public void setup() {
          filePrefix = "OE00AQ8" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.8/2.4 ;   
          ysize = 2.8/2.4 ;   
          xmin = -1.4 ;
          xmax = 2.4 ;
          ymin = -1.4 ;
          ymax = 1.4 ;
          topmargin = 0.2 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1) ;
          double pi = Math.PI ;
          double p8d = 180.0/8.0 ;
          fEnv("psFillGray", 0.8) ;
          fCurve("[(1+cos(t))*cos(t), (1+cos(t))*sin(t)]",1, 0, pi, FILLED);
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, 1, 1, FILLED+CLOSED) ;

          fCurve("[(1+cos(t))*cos(t), (1+cos(t))*sin(t)]",1, 0, 2*pi, CLOSED);



          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax+0.1, 0.0, "lc", "$x$") ;
          fTeXlabel(0.0, ymax+0.1, "bc", "$y$") ;

          fTeXlabel(1.85, 0.9, "lc", "$r=1+\\cos(\\theta)$") ;
          fTeXlabel(-0.93, 0.6, "rc", "$r=1$") ;

     }
}
