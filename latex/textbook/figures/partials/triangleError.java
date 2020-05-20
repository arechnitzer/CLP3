                  /*  File:  triangleError.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleError extends Template {

     static {templateClass = new triangleError() ; }

     public void setup() {
          filePrefix = "triangleError" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.8*2.0 ;      // in inches
          ysize = 0.7*1.5 ;   // in inches. 
          xmin = -1 ;
          xmax = 7 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
     


     double angle = Math.atan2(5, 4) ;
     double x   = 4 ;
     double xx   = 6 ;
     double y   = 5 ;

     fEnv("useColorPs", "true") ;
     String Red = "0 1 1 0 setcmykcolor  " ;
     String Black = "0 0 0 1 setcmykcolor  " ;
     String Blue = "1 1 0 0 setcmykcolor  " ;
     fEnv("lineWidth", 1.0) ;
     canvas.append( new fPsWrite(Red+"\n")) ;

     fEnv("lineWidth", 1.0) ;
     fLine(0, 0, xx, 0) ;
     fLine(0, 0, x, y) ;
     fLine(xx, 0,  x, y) ;

     canvas.append( new fPsWrite("0.7 setgray\n")) ;
     fEnv("lineWidth", 0.5) ;
     fLine(x, 0,  x, y) ;


     fTeXlabel(1.1,0.25, "bl", "$\\theta$") ;
     fTeXlabel(xx/2, -0.5, "tc", "$b$") ;
     fTeXlabel(x/2-0.1, y/2+0.2, "br", "$a$") ;
          
     }
}
