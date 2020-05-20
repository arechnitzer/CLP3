                  /*  File:  OE03AQ5a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE03AQ5a extends Template {

     static {templateClass = new OE03AQ5a() ; }

     public void setup() {
          filePrefix = "OE03AQ5a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.9/2.4 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.2 ;
          xmax = 1.7 ;
          ymin = -0.2 ;
          ymax = 2.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
//          fEnv("lineWidth", 2.0) ;
//          fEnv("psGray", 0.7) ;
//          fLine(0,0.5, 0.5,0.5) ;
//          fLine(0,1.5, 0.5,1.5) ;
          fEnv("psGray", 0) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fLine(0,1, -0.1,1) ;
          fLine(0,2, -0.1,2) ;
          fLine(1,0, 1,-0.1) ;
          fTeXlabel(-0.15,1, "rc", "$1$") ;
          fTeXlabel(-0.15,2, "rc", "$2$") ;
          fTeXlabel(1,-0.15, "tc", "$1$") ;
          fEnv("lineWidth", 1.0) ;
          fLine(0,0, 1,1) ;
          fLine(1,1, 0,2) ;
          fLine(0,0, 0, 2) ;

          fTeXlabel(xmax+0.07, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.07, "bc", "$y$") ;
          fTeXlabel(0.65, 0.5, "lc", "$x=y$") ;
          fTeXlabel(0.65, 1.5, "lc", "$x=2-y$") ;
          
     }
}
