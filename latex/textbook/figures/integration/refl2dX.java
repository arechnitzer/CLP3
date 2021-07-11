                  /*  File:  refl2dX.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class refl2dX extends Template {

     static {templateClass = new refl2dX() ; }

     public void setup() {
          filePrefix = "refl2dX" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -120 ;
          xmax = 120 ;
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
          String LtBlue   = "0.2     0.6     0.8 setrgbcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          double x = 50 ;  
          double y1 = 60 ;
          double y2 = 20 ;
          double y3 = -20 ;
          double y4 = -60 ;
          double r = 2.5 ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(x, y1, r, r, FILLED) ;
          fDisk(-x, y1, r, r, FILLED) ;
          fArrow(x-r, y1, -x+r, y1) ;
          fTeXlabel(x+5, y1, "lc", "$(5,6)$") ;
          fTeXlabel(-x-5, y1, "rc", "$(-5,6)$") ;

          fEnv("psFillColor", Yellow) ;
          canvas.append( new fPsWrite(Yellow+"\n")) ;
          fDisk(x, y2, r, r, FILLED) ;
          fDisk(-x, y2, r, r, FILLED) ;
          fArrow(x-r, y2, -x+r, y2) ;
          fTeXlabel(x+5, y2, "lc", "$(5,2)$") ;
          fTeXlabel(-x-5, y2, "rc", "$(-5,2)$") ;

          fEnv("psFillColor", Red) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(x, y3, r, r, FILLED) ;
          fDisk(-x, y3, r, r, FILLED) ;
          fArrow(x-r, y3, -x+r, y3) ;
          fTeXlabel(x+5, y3, "lc", "$(5,-2)$") ;
          fTeXlabel(-x-5, y3, "rc", "$(-5,-2)$") ;

          fEnv("psFillColor", LtBlue) ;
          canvas.append( new fPsWrite(LtBlue+"\n")) ;
          fDisk(x, y4, r, r, FILLED) ;
          fDisk(-x, y4, r, r, FILLED) ;
          fArrow(x-r, y4, -x+r, y4) ;
          fTeXlabel(x+5, y4, "lc", "$(5,-6)$") ;
          fTeXlabel(-x-5, y4, "rc", "$(-5,-6)$") ;

          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          fTeXlabel(0, ymin-3, "tc", "reflection across the $y$-axis") ;
     }
}
