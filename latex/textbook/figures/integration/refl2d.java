                  /*  File:  refl2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class refl2d extends Template {

     static {templateClass = new refl2d() ; }

     public void setup() {
          filePrefix = "refl2d" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -100 ;
          xmax = 100 ;
          ymin = -75 ;
          ymax = 75 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String White  = "1 1 1 setrgbcolor  " ;
          String Black  = "0 0 0 setrgbcolor  " ;
          String Yellow = "0.86667 0.66667 0.2 setrgbcolor  " ;
          String Red    = "0.73333 0.33333 0.4 setrgbcolor  " ;
          String Blue   = "      0 0.26667 0.53333 setrgbcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          double x = 50 ;  
          double y = 50 ;
          double r = 2.5 ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fDisk(x, y, r, r, FILLED) ;
          fDisk(-x, y, r, r, FILLED) ;
          fDisk(x, -y, r, r, FILLED) ;
          fDisk(-x, -y, r, r, FILLED) ;
          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          fTeXlabel(x+5, y, "lc", "$(x,y)$") ;
          fTeXlabel(-x-5, y, "rc", "$(-x,y)$") ;
          fTeXlabel(x+5, -y, "lc", "$(x,-y)$") ;
          fTeXlabel(-x-5, -y, "rc", "$(-x,-y)$") ;


     }
}
