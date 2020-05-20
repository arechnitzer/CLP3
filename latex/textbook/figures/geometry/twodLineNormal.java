                  /*  File:  twodLineNormal.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class twodLineNormal extends Template {

     static {templateClass = new twodLineNormal() ; }

     public void setup() {
          filePrefix = "twodLineNormal" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -5 ;
          xmax = 95 ;
          ymin = -5 ;
          ymax = 45 ;
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
         fLine( 70, -5,    -5, 32.5) ;
         fTeXlabel(43, 13, "cl", "$(x_0,y_0)$") ;
         fTeXlabel(10, 27, "bl", "$(x,y)$") ;
         fTeXlabel(51, 31, "bl", "$\\vn$") ;
         fEnv("lineWidth", 1.0) ;
         fLine(-5, 0,  95, 0) ;
         fLine(0, -5,   0, 45) ;
         fLine(42, 14,  38, 16) ;
         fLine(38, 16,  36, 12) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fArrow(40, 10,   10, 25) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(40, 10,   50, 30) ;
         fDisk(40, 10, 1.5, 1.5, FILLED) ;
         fDisk(10, 25, 1.5, 1.5, FILLED) ;
     }
}
