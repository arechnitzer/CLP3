                  /*  File:  crossR.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class crossR extends Template {

     static {templateClass = new crossR() ; }

     public void setup() {
          filePrefix = "crossR" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax =  50;
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
         fRotate(30*Math.PI/180.0) ;
         fArrow(0, 0,    50, 0) ;
         fArrow(0, 0,    40, 30) ;
         fArrow(0, 0,    0, 50) ;
         fEllipticalArc(0, 0, 15, 15, -200, 95, OPEN ) ;
         fArrowhead(7.5,  10.5, 140) ;
         fTeXlabel(59, 0, "cc", "$\\va$") ;
         fTeXlabel(51, 30, "cc", "$\\vb$") ;
         fTeXlabel(-25, 50, "cc", "$\\va\\times\\vb$") ;

     }
}
