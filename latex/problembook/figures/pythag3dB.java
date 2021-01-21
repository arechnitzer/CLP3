                  /*  File:  pythag3dB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pythag3dB extends Template {

     static {templateClass = new pythag3dB() ; }

     public void setup() {
          filePrefix = "pythag3dB" ;    // used as the prefix for any ps or lbl files written
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
          fLine(0,0,  80, 0) ;
          fLine(0,0,  -50, -70) ;

           double y = 15 ;
          fEnv("lineWidth", 1.4) ;
//          fLine(0,0, -25, -35) ;
          fLine(-25, 75,   y, 75) ;
          fLine(y, -35,   y, 75) ;
          fLine(-25, -35,  y, 75) ;


          fEnv("lineWidth", 0.5) ;
          fDisk(y, 75,  3, 3, FILLED) ;
          fDisk(y, -35,  3, 3, FILLED) ;
          fDisk(-25, -35,  3, 3, FILLED) ;
          fDisk(-25, 75,  3, 3, FILLED) ;
          fLine(-25, -35,  y, -35) ;
//          fLine(0,0, 50,-35) ;
//          fLine(0,0, 50, 75) ;

          fTeXlabel(-29, 75, "rc", "$(2,0,3)$") ;
          fTeXlabel(-29, -35, "rc", "$(2,0,0)$") ;
          fTeXlabel(y+5, -35, "lc", "$(2,1,0)$") ;
          fTeXlabel(y+5, 75, "lc", "$(2,1,3)$") ;
//          fTeXlabel(-15, -10, "rc", "$x$") ;
          fTeXlabel(0.5*(-25+y), -40, "tc", "$1$") ;
          fTeXlabel(-10, 80, "bc", "$1$") ;
          fTeXlabel(y+5, 35, "lc", "$3$") ;

          fTeXlabel(-52, -74, "rt", "$x$") ;
          fTeXlabel(85, -1, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}
