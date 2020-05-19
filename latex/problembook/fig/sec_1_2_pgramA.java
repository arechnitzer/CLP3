                  /*  File:  sec_1_2_pgramA.java    */

import figPac.* ;
import java.applet.* ;
import java.awt.* ;

public class sec_1_2_pgramA extends Template {

     static {templateClass = new sec_1_2_pgramA() ; }

     public void setup() {
          filePrefix = "sec_1_2_pgramA" ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(-70.0, -20.0, 30.0, 0.0) ;
          fArrow(-40.0,  30.0, 60.0, 50.0) ;
          fArrow(-70.0, -20.0, -40.0, 30.0) ;
          fArrow( 30.0,   0.0,  60.0, 50.0) ;
          fTeXlabel(-55, 05, "br", "$\\vb$") ;
          fTeXlabel(-55+100+2, 05+20, "tl", "$\\vb$") ;
          fTeXlabel(-20, -12, "tl", "$\\va$") ;
          fTeXlabel(-20+30, -12+50+4, "br", "$\\va$") ;
//          fTeXlabel(-30.0, 9.3, "cl", "$h$") ;
          fEnv("lineWidth", 0.5) ;
//          fLine(-40.0, 30.0, -28.1, -11.9) ;
//          fEllipticalArc(-70.0, -20.0, 10, 10, 13.0, 57.0, 1) ;
//          fTeXlabel(-58, -9, "cl", "$\\theta$") ;
     }
}
