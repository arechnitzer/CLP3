                  /*  File:  point2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class point2d extends Template {

     static {templateClass = new point2d() ; }

     public void setup() {
          filePrefix = "point2d" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -10 ;
          xmax = 140 ;
          ymin = -10 ;
          ymax = 140 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(-10, 0, 140, 0) ;
          fLine( 0, -10, 0, 140) ;
          fEnv("lineWidth", 1.4) ;
          fLine(0, 0, 100, 0) ;
          fLine(100, 0,   100, 90) ;
          fDisk(100, 90, 3, 3, FILLED) ;
          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          fTeXlabel(50, -5, "tc", "$x$") ;
          fTeXlabel(104, 45, "lc", "$y$") ;
          fTeXlabel(105, 90, "lc", "$(x,y)$") ;


     }
}
