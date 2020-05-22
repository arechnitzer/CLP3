                  /*  File:  area.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class area extends Template {

     static {templateClass = new area() ; }

     public void setup() {
          filePrefix = "area" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.75 ;      // in inches
          ysize = 0.75 ;   // in inches. 
          xmin =  0 ;
          xmax = 65 ;
          ymin =  0 ;
          ymax = 65 ;
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
         fRotate(10*Math.PI/180.0) ;
         fArrow(0, 0, 50, 0) ;
         fArrow(0, 0, 20, 40) ;
         fArrow(50, 0,  70, 40) ;
         fArrow(20, 40, 70, 40) ;
         fEllipticalArc(0, 0, 13, 13, 10, 70, OPEN ) ;
         fTeXlabel(35, -7, "cc", "$\\va$") ;
         fTeXlabel(55, 48, "cc", "$\\va$") ;
         fTeXlabel(6, 31, "cc", "$\\vb$") ;
         fTeXlabel(72, 24, "cc", "$\\vb$") ;
         fTeXlabel(18.5, 11.5, "cc", "$\\theta$") ;
     }
}
