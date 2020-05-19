                  /*  File:  subtract.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class subtract extends Template {

     static {templateClass = new subtract() ; }

     public void setup() {
          filePrefix = "subtract" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.2 ;      // in inches
          ysize = 1*1.2 ;   // in inches. 
          xmin = -10 ;
          xmax = 190 ;
          ymin = -10 ;
          ymax = 90 ;
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
         fLine(-5, 0, 190, 0 ) ;
         fLine(0, -5, 0, 90 ) ;
         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fArrow(0, 0,   150, 90 ) ;
         fArrow(0, 0,    100, 10 ) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(0, 0,    50, 80 ) ;
         fArrow(150, 90,   50, 80 ) ;
         fArrow(100, 10,    150, 90 ) ;

         fTeXlabel(125, 40, "lc", "$ \\va- \\vb$" ) ;
         fTeXlabel(75, 50, "rb", "$ \\va$" ) ;
         fTeXlabel(70, 12, "rb", "$ \\vb$" ) ;
         fTeXlabel(80, 87, "rb", "$- \\vb$" ) ;
         fTeXlabel(39, 67, "rb", "$ \\va- \\vb$" ) ;
     }
}
