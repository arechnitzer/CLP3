                  /*  File:  sec1_1_Q1b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sec1_1_Q1b extends Template {

     static {templateClass = new sec1_1_Q1b() ; }

     public void setup() {
          filePrefix = "sec1_1_Q1b" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.25 ;      // in inches
          ysize = 1.25 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.1 ;
          xmax = 1.6 ;
          ymin = -0.1 ;
          ymax = 1.6 ;
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
          double r = 0.05 ;
          fDisk(1,0, r,r, FILLED) ;
          fTeXlabel(1.0,-0.05, "tr", "$(1,0)$") ;
          fDisk(0,1, r,r, FILLED) ;
          fTeXlabel(-0.05,1.0, "tr", "$(0,1)$") ;


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(xmin, 1-xmin, xmax, 1-xmax) ;
          fTeXlabel(0.55,0.5, "bl", "$x+y=1$") ;





     }
}
