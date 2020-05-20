                  /*  File:  OE00AQ3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE00AQ3 extends Template {

     static {templateClass = new OE00AQ3() ; }

     public void setup() {
          filePrefix = "OE00AQ3" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*0.6 ;      // in inches
          ysize = 1.0*0.6 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -10 ;
          xmax = 6 ;
          ymin = -5 ;
          ymax =  5 ;
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
          fEnv("lineWidth", 1.0) ;
          fDisk( -2, 0, 6, 3, CLOSED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fTeXlabel(xmax+0.3, 0, "lc", "$x$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(0, ymax+0.5, "bc", "$y$") ;
          
     }
}
