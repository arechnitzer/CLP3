                  /*  File:  basis3d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class basis3d extends Template {

     static {templateClass = new basis3d() ; }

     public void setup() {
          filePrefix = "basis3d" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3 ;      // in inches
          ysize = 1.3 ;   // in inches. 
          xmin = -80 ;
          xmax = 120 ;
          ymin = -80 ;
          ymax = 120 ;
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
          fLine(0, 0, 100, 0) ;
          fLine(0, 0, 0, 100) ;
          fLine(0, 0, -50*0.9, -70*0.9) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          fArrow(0, 0, 80, 0) ;
          fArrow(0, 0, 0, 80) ;
          fArrow(0, 0, -50*0.9*0.8, -70*0.9*0.8) ;

          fTeXlabel(-50*0.9-7, -70*0.9, "cr", "$x$") ;
          fTeXlabel(110, 0, "lc", "$y$") ;
          fTeXlabel(0, 110, "bc", "$z$") ;
          fTeXlabel(-50*0.9*0.8+20, -70*0.9*0.8, "bl", "$\\hi$") ;
          fTeXlabel(80.5, 10.5, "br", "$\\hj$") ;
          fTeXlabel(10, 80, "tl", "$\\hk$") ;

     }
}
