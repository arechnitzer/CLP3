                  /*  File:  OE03AQ3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE03AQ3 extends Template {

     static {templateClass = new OE03AQ3() ; }

     public void setup() {
          filePrefix = "OE03AQ3" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.1/4.1*2 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.1 ;
          xmax = 5 ;
          ymin = -0.1 ;
          ymax = 4 ;
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
          fEnv("psFillGray", 0.7) ;
          fCurve("4/x", 0, 2, 4, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fCurve("4/x", 0, 1, xmax, OPEN) ;
          fLine(-0.1, 3.05, 5, 0.5) ;
          fEnv("lineWidth", 1.0) ;
          fCurve("4/x", 0, 2, 4, OPEN) ;
          fLine(2,2, 4,1) ;
          fEnv("psFillGray", 0.0) ;
          double r = 0.06 ;
          fDisk(2,2, r,r, FILLED) ;
          fDisk(4,1, r,r, FILLED) ;
          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(1.3, ymax+0.1, "bc", "$xy=4$") ;
          fTeXlabel(-0.2, 3.05, "rc", "$x+2y=6$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fTeXlabel(4.1, 1, "lb", "$(4,1)$") ;
          fTeXlabel(2.1, 2, "lb", "$(2,2)$") ;
          
     }
}
