                  /*  File:  basis2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class basis2d extends Template {

     static {templateClass = new basis2d() ; }

     public void setup() {
          filePrefix = "basis2d" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.7 ;      // in inches
          ysize = 0.7 ;   // in inches. 
          xmin = -1 ;
          xmax = 14 ;
          ymin = -1 ;
          ymax = 14 ;
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
          fLine(0, ymin, 0, ymax) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          fArrow(0, 0, 10, 0) ;
          fArrow(0, 0, 0, 10) ;

          fTeXlabel(xmax, -0.8, "tr", "$x$") ;
          fTeXlabel(-0.5, ymax, "tr", "$y$") ;
          fTeXlabel(10, 1.5, "br", "$\\hi$") ;
          fTeXlabel(1.5, 10, "tl", "$\\hj$") ;

     }
}
