                  /*  File:  sec_1_2_triangle.java    */

import figPac.* ;
import java.applet.* ;
import java.awt.* ;

public class sec_1_2_triangle extends Template {

     static {templateClass = new sec_1_2_triangle() ; }

     public void setup() {
          filePrefix = "sec_1_2_triangle" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*1.2 ;   
          ysize = 1.25*1.2 ;   
          xmin = -100.0 ;
          xmax = 100.0 ;
          ymin = -50.0 ;
          ymax = 75.0 ;
          topmargin = -.2 ;
          bottommargin = -.2 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
//          fLine(-70.0, 60.0, -70.0, -30.0) ;
//          fLine(-80.0, -20.0, 70.0, -20.0) ;
          fArrow(-70.0, -20.0, 30.0, 0.0) ;
          fArrow(-70.0, -20.0, -40.0, 30.0) ;
          fLine(-40.0, 30.0, 30.0, 0.0) ;
          fTeXlabel(-42, 30, "br", "$\\vb$") ;
          fTeXlabel(32, 3.0, "cl", "$\\va$") ;
          fTeXlabel(-30.0, 9.3, "cl", "$h$") ;
          fEnv("lineWidth", 0.5) ;
          fLine(-40.0, 30.0, -28.1, -11.9) ;
          fEllipticalArc(-70.0, -20.0, 10, 10, 13.0, 57.0, 1) ;
          fTeXlabel(-58, -9, "cl", "$\\theta$") ;
     }
}
