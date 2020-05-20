                  /*  File:  vector2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class vector2d extends Template {

     static {templateClass = new vector2d() ; }

     public void setup() {
          filePrefix = "vector2d" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -50 ;
          xmax = 150 ;
          ymin = -10 ;
          ymax = 140 ;
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
         fLine(-10, 0, 140, 0) ;
         fLine(0, -10, 0, 140) ;
         fEnv("lineWidth", 0.8) ;
         fLine(0, 0, 100, 0) ;
         fLine(100, 0,   100, 90) ;
         fDisk (100, 90, 3, 3, FILLED) ;
         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(0, 0,   100, 90) ;
         fTeXlabel(143, 0, "lc", "$x$") ;
         fTeXlabel(0, 145, "bc", "$y$") ;
         fTeXlabel(50, -5, "tc", "$a$") ;
         fTeXlabel(104, 45, "lc", "$b$") ;
         fTeXlabel(105, 90, "lc", "$(a,b)$") ;
          
     }
}
