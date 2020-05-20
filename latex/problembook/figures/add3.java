                  /*  File:  add3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class add3 extends Template {

     static {templateClass = new add3() ; }

     public void setup() {
          filePrefix = "add3" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.4*0.5 ;      // in inches
          ysize = 1.4*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  4.2 ;
          ymin = -1.2 ;
          ymax =  0.2 ;
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
          fTeXlabel(xmax+0.05, 0, "cl", "$x$") ;
          fTeXlabel(0, ymax+0.05, "cb", "$y$") ;

         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double ax = 2 ; double ay = 0 ;
         double bx = 1 ; double by = 1 ;
         fArrow(0, 0,   2*ax, 2*ay ) ;
         fArrow(2*ax, 2*ay,    2*ax-bx, 2*ay-by ) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(0, 0,    2*ax-bx, 2*ay-by ) ;

         fTeXlabel(ax, 0.07, "bc", "$ 2\\va$" ) ;
         fTeXlabel(2*ax-bx/2, -by/2, "tl", "$ -\\vb$" ) ;
         fTeXlabel( 0.7*(2*ax-bx), 0.7*(-by), "rt", "$ 2\\va - \\vb$" ) ;
     }
}
