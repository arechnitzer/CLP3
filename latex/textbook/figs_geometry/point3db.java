                  /*  File:  point3db.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class point3db extends Template {

     static {templateClass = new point3db() ; }

     public void setup() {
          filePrefix = "point3db" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.75 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -50 ;
          xmax = 100 ;
          ymin = -75 ;
          ymax = 100 ;
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
          fLine(0,0,  0, 100) ;
          fLine(0,0,  100, 0) ;
          fLine(0,0,  -50, -70) ;

          fEnv("lineWidth", 1.4) ;
          fLine(75,0, 50, -35) ;
          fLine(-25, -35,   50, -35) ;
          fLine(50, -35,    50, 75) ;

          fDisk(50, 75,  3, 3, FILLED) ;

          fTeXlabel(55, 75, "lc", "$(x,y,z)$") ;
          fTeXlabel(67, -20, "lc", "$x$") ;
          fTeXlabel(12.5, -40, "tc", "$y$") ;
          fTeXlabel(55, 35, "lc", "$z$") ;

          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}
