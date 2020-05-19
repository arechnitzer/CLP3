                  /*  File:  sec1_1_Q1e.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sec1_1_Q1e extends Template {

     static {templateClass = new sec1_1_Q1e() ; }

     public void setup() {
          filePrefix = "sec1_1_Q1e" ; // the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1.2 ;
          xmax = 1.5 ;
          ymin = -0.2 ;
          ymax = 2.5 ;
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
          fEnv("psFillGray", 0.8) ;
          fDisk(0,1, 1,1, FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fEnv("psFillGray", 0.0) ;
          double r = 0.06 ;
          fDisk(0,1, r,r, FILLED) ;
          fTeXlabel(0.05, 0.95, "tl", "$(0,1)$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fEllipticalArc(0,1, 1,1, 0, 360, OPEN) ;
          fTeXlabel(0.5,1.9, "bl", "$x^2+y^2=2y$") ;





     }
}
