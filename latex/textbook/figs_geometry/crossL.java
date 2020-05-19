                  /*  File:  crossL.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class crossL extends Template {

     static {templateClass = new crossL() ; }

     public void setup() {
          filePrefix = "crossL" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin =  -100 ;
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
         fArrow(0, 0,    0, -50) ;
         fLine(0, -75,   0, 75) ;
         fTeXlabel(59, 0, "cc", "$\\va$") ;
         fTeXlabel(51, 30, "cc", "$\\vb$") ;
         fTeXlabel(-12, 50, "cc", "$\\vc$") ;
         fTeXlabel(13, -42, "cc", "$\\vd$") ;

     }
}
