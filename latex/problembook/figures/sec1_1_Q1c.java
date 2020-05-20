                  /*  File:  sec1_1_Q1c.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sec1_1_Q1c extends Template {

     static {templateClass = new sec1_1_Q1c() ; }

     public void setup() {
          filePrefix = "sec1_1_Q1c" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2.5 ;
          xmax = 3.0 ;
          ymin = -2.5 ;
          ymax = 3.0 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          double r = 0.1 ;
          fDisk(2,0, r,r, FILLED) ;
          fTeXlabel(1.9,-0.05, "tr", "$(2,0)$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc(0,0, 2,2, 0, 360, OPEN) ;
          fTeXlabel(0.5,2.0, "bl", "$x^2+y^2=4$") ;





     }
}
