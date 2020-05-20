                  /*  File:  triangleString.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleString extends Template {

     static {templateClass = new triangleString() ; }

     public void setup() {
          filePrefix = "triangleString" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      
          ysize = 0.75 ;  
          xmin = -100 ;
          xmax =  100 ;
          ymin = -50 ;
          ymax = 50 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = -0.4 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine( 0, 0, 100, 50) ;
          fLine( 0, 0, 100, 0) ;
          fLine( 100, 0, 100, 50) ;
          fEllipticalArc( 0, 0, 30, 30, 0, 26.6, OPEN) ;

          fTeXlabel( 35, 3, "bl", "$\\theta$") ;
          fTeXlabel( 103, 25, "lc", "$\\tan\\theta$") ;
          fTeXlabel( 50, -3, "tc", "$1$") ;
          fTeXlabel( 60, 30, "rb", "$\\sqrt{1+\\tan^2\\theta}$"  ) ;        
     }
}
