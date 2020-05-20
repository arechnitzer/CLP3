                  /*  File:  sec1_1_Q1a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sec1_1_Q1a extends Template {

     static {templateClass = new sec1_1_Q1a() ; }

     public void setup() {
          filePrefix = "sec1_1_Q1a" ; // used as the prefix for any ps or lbl files written
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

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(xmin, xmin, xmax, xmax) ;
          fTeXlabel(0.85,0.8, "tl", "$y=x$") ;





     }
}
