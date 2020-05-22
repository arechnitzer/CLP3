                  /*  File:  negmul.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class negmul extends Template {

     static {templateClass = new negmul() ; }

     public void setup() {
          filePrefix = "negmul" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -50 ;
          xmax =  50 ;
          ymin = -55 ;
          ymax =  45;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, -50, 0, 45) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk( 0, 0,  3, 3, FILLED) ;
          fArrow(0, 0, 22.5, 22.5) ;
          fArrow(0, 0, -45, -45) ;

          fTeXlabel(25, 22.5, "tl", "$\\va$") ;
          fTeXlabel(-47, -42, "br", "$-2\\va$") ;
     }
}
