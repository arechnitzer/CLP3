                  /*  File:  tetrahedron.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class tetrahedron extends Template {

     static {templateClass = new tetrahedron() ; }

     public void setup() {
          filePrefix = "tetrahedron" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 1.6 ;   
          xmin = -40.0 ;
          xmax = 60.0 ;
          ymin = -40.0 ;
          ymax = 40.0 ;
          topmargin = .2 ;
          bottommargin = -.2 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fLine(-20.0, -20.0, 40.0, 0.0) ;
          fLine(0.0, 40.0, 40.0, 0.0) ;
          fLine(0.0, 40.0, -20.0, -20.0) ;
          fTeXlabel(12.0, 12.0, "cc", "$C$", "C") ;
          fTeXlabel(3.0, -7.0, "cc", "$B$", "B") ;
          fTeXlabel(-6.0, 5.0, "cc", "$A$", "A") ;
          fTeXlabel(42.0, 0.0, "cl", "$\\va$", "a") ;
          fTeXlabel(0.0, 42.0, "bc", "$\\vb$", "b") ;
          fTeXlabel(-21.5, -21.5, "tr", "$\\vc$", "c") ;

         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         fEnv("useColorPs", "true") ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(0.0, 0.0, 0.0, 40.0) ;
          fArrow(0.0, 0.0, 40.0, 0.0) ;
          fArrow(0.0, 0.0, -20.0, -20.0) ;

     }
}
