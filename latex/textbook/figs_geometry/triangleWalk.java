                  /*  File:  triangleWalk.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleWalk extends Template {

     static {templateClass = new triangleWalk() ; }

     public void setup() {
          filePrefix = "triangleWalk" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      
          ysize = 1.5 ;  
          xmin = -1 ;
          xmax =  10 ;
          ymin = -1 ;
          ymax = 10 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine( 0, 0, 6, 0) ;
          fLine( 6, 0, 6, 6) ;
          fEllipticalArc( 0, 0, 1, 1, 0, 45, OPEN) ;
          fEllipticalArc( 6, 6, 1, 1, 225, 270, OPEN) ;
          fEnv("lineWidth", 1.0) ;
          fArrow( 0, 0, 6, 6) ;


          fTeXlabel( 1.2, 0.3, "bl", "$45^\\circ$") ;
          fTeXlabel( 3, -0.2, "tc", "$1$") ;
          fTeXlabel( 6.2, 3, "cl", "$1$") ;
          fTeXlabel( 3.3, 3.3, "br", "$\\llt 1,1\\rgt$") ;
     }
}
