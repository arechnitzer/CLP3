                  /*  File:  absMaxMin.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class absMaxMin extends Template {

     static {templateClass = new absMaxMin() ; }

     public void setup() {
          filePrefix = "absMaxMin" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -2 ;
          xmax = 8 ;
          ymin = -2 ;
          ymax = 8 ;
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
          fTeXlabel(xmax, -0.3, "tr", "$x$") ;
          fTeXlabel(-0.2, ymax, "tr", "$y$") ;
          fLine(xmin, ymin, xmax, ymax) ;
          fTeXlabel(xmax+0.5, ymax+0.2, "cl", "$y=f(x)=x$" ) ;
          double One = 5 ;
          fLine(One, 0, One, -0.5) ;
          fTeXlabel(One, -0.7, "tc", "$1$") ;
          fLine(0, One, -0.5, One) ;
          fTeXlabel(-0.6, One, "cr", "$1$") ;
          fEnv("lineWidth", 2.0) ;
          fLine(0, 0, One, One) ;

          
     }
}
