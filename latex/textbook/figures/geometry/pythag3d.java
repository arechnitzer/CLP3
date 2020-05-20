                  /*  File:  pythag3d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pythag3d extends Template {

     static {templateClass = new pythag3d() ; }

     public void setup() {
          filePrefix = "pythag3d" ;    // used as the prefix for any ps or lbl files written
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
          fLine(0,0, -25, -35) ;
          fLine(-25, -35,   50, -35) ;
          fLine(50, -35,    50, 75) ;


          fEnv("lineWidth", 0.5) ;
          fDisk(50, 75,  3, 3, FILLED) ;
          fDisk(50, -35,  3, 3, FILLED) ;
          fDisk(-25, -35,  3, 3, FILLED) ;
          fLine(0,0, 50,-35) ;
          fLine(0,0, 50, 75) ;

          fTeXlabel(-29, -35, "rc", "$(x,0,0)$") ;
          fTeXlabel(55, -35, "lc", "$(x,y,0)$") ;
          fTeXlabel(55, 75, "lc", "$(x,y,z)$") ;
          fTeXlabel(-15, -10, "rc", "$x$") ;
          fTeXlabel(12.5, -40, "tc", "$y$") ;
          fTeXlabel(55, 35, "lc", "$z$") ;

          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}
