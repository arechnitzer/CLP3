                  /*  File:  optExampleAa.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleAa extends Template {

     static {templateClass = new optExampleAa() ; }

     public void setup() {
          filePrefix = "optExampleAa" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2*3.4/2.4 ;      // in inches
          ysize = 1.2 ;   // in inches. 
          xmin = -1.7 ;
          xmax = 1.7 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;   // in inches
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
          fLine(xmin, 0, 1.3, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(1.2+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          fDisk(0, 0, 1, 1, CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.06 ;
          double th = 50*Math.PI/180 ;
          double x = Math.cos(th) ;
          double y = Math.sin(th) ;
          fLine(0, 0, x,y) ;
          fLine(x, 0, x,y) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x, y+r, "bl", 
                             "$(\\cos t,\\sin t)$") ;
          fEnv("lineWidth", 0.5) ;
          double R = 0.2 ;
          fEllipticalArc(0, 0, R, R, 0, 50, OPEN) ;
          fTeXlabel(R+0.04, 0.05, "bl", "$t$") ;
          fTeXlabel(0.6*x, 0.6*y, "br", "$1$") ;

     }
}
