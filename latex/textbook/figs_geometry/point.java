                  /*  File:  point.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class point extends Template {

     static {templateClass = new point() ; }

     public void setup() {
          filePrefix = "point" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -300 ;
          xmax = 300 ;
          ymin = -100 ;
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
          fTranslate(80,0) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0,0,  0, 100) ;
          fLine(0,0,  100, 0) ;
          fLine(0,0,  -50, -70) ;

          fEnv("lineWidth", 1.0) ;
          fLine(0,0, -25, -35) ;
          fLine(-25, -35,   50, -35) ;
          fLine(50, -35,    50, 75) ;

          fDisk(50, 75,  3, 3, FILLED) ;

          fTeXlabel(55, 75, "lc", "$(a,b,c)$") ;
          fTeXlabel(-15, -10, "rc", "$a$") ;
          fTeXlabel(12.5, -40, "tc", "$b$") ;
          fTeXlabel(55, 35, "lc", "$c$") ;

          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;


          fTranslate(-300, 0) ;
          fTranslate(-30, -50) ;
          fEnv("lineWidth", 0.5) ;
          fLine(-10, 0, 140, 0) ;
          fLine( 0, -10, 0, 140) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0, 0, 100, 0) ;
          fLine(100, 0,   100, 90) ;
          fDisk(100, 90, 3, 3, FILLED) ;
          fTeXlabel(143, 0, "lc", "$x$") ;
          fTeXlabel(0, 145, "bc", "$y$") ;
          fTeXlabel(50, -5, "tc", "$a$") ;
          fTeXlabel(104, 45, "lc", "$b$") ;
          fTeXlabel(105, 90, "lc", "$(a,b)$") ;


     }
}
