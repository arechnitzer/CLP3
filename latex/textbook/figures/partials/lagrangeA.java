                  /*  File:  lagrangeA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class lagrangeA extends Template {

     static {templateClass = new lagrangeA() ; }

     public void setup() {
          filePrefix = "lagrangeA" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 10.0*0.2 ;      // in inches
          ysize = 5.0*0.2 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "cl", "$x$") ;
          fTeXlabel(0, ymax+0.2, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          fDisk(0, 0, 4, 2, CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.2 ;
          double x = 4 ; double y = 0 ;
          fDisk(x, y, r, r, FILLED) ;
          fDisk(-x, y, r, r, FILLED) ;
          fTeXlabel(-1, 2, "br", "$x^2+4y^2=16$") ;
          fTeXlabel(-4.1, -0.1, "tr", "$\\scriptstyle (-4,0)$") ;
          fTeXlabel(3.8, 0.1, "br", "$\\scriptstyle (4,0)$") ;

     }
}
