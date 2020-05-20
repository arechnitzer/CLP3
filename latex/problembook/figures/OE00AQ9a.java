                  /*  File:  OE00AQ9a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE00AQ9a extends Template {

     static {templateClass = new OE00AQ9a() ; }

     public void setup() {
          filePrefix = "OE00AQ9a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax = 2.3 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0, 0, 2, 2, 0, 180, FILLED) ;
          fEnv("psFillGray", 0.4) ;
          fEllipticalArc(0, 0, 2, 2, 40, 47, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;

          fTeXlabel(xmax+0.05, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.05, "bc", "$y$") ;          
          fTeXlabel(1.45, 1.45, "bl", "$x^2+y^2=4$") ;          
     }
}
